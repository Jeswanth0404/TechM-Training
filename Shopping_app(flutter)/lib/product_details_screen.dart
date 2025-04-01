import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class ProductDetailsScreen extends StatelessWidget {
  final DocumentSnapshot product;

  ProductDetailsScreen({required this.product});

  void addToCart(BuildContext context) async {
    FirebaseFirestore.instance.collection('cart').add({
      'name': product['name'],
      'price': product['price'],
      'image': product['image'],
      'quantity': 1, // Default quantity is 1
    }).then((_) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text("${product['name']} added to cart!")),
      );
    }).catchError((error) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text("Failed to add to cart: $error")),
      );
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(product['name'])),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Image.network(
            product['image'],
            height: 200,
            width: double.infinity,
            fit: BoxFit.cover,
            errorBuilder: (context, error, stackTrace) =>
                Icon(Icons.error, size: 100),
          ),
          SizedBox(height: 20),
          Text(product['name'], style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
          Text("\$${product['price']}", style: TextStyle(fontSize: 18, color: Colors.green)),
          SizedBox(height: 10),
          Padding(
            padding: EdgeInsets.symmetric(horizontal: 16.0),
            child: Text(product['description'], textAlign: TextAlign.center),
          ),
          SizedBox(height: 20),
          ElevatedButton.icon(
            onPressed: () => addToCart(context),
            icon: Icon(Icons.shopping_cart),
            label: Text("Add to Cart"),
          ),
        ],
      ),
    );
  }
}
