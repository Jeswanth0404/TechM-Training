import 'dart:convert';
import 'package:http/http.dart' as http;

class ApiService {
  static Future<List<dynamic>> fetchProducts() async {
    try {
      print("Fetching API Data...");
      final response = await http.get(Uri.parse("https://fakestoreapi.com/products"));

      if (response.statusCode == 200) {
        List<dynamic> apiProducts = json.decode(response.body);

        // Add custom local products
        List<dynamic> localProducts = [
          {
            "id": 21,
            "title": "Smart Watch",
            "price": 49.99,
            "image": "https://rukminim3.flixcart.com/image/850/1000/xif0q/bp-monitor/s/c/w/bp-15-and-t55-smartwatch-bp-15-and-fitpro-t55-smartwatch-dr-original-imagfynzhjgwetxk.jpeg?q=20&crop=false",
          },
          {
            "id": 22,
            "title": "Wireless Earbuds",
            "price": 29.99,
            "image": "https://media-ik.croma.com/prod/https://media.croma.com/image/upload/v1721355530/Croma%20Assets/Entertainment/Wireless%20Earbuds/Images/308226_qboyzq.png",
          },
          {
            "id": 23,
            "title": "Laptop Stand",
            "price": 19.99,
            "image": "https://m.media-amazon.com/images/I/71cOnHXOg9L.jpg",
          }
        ];

        return apiProducts + localProducts; // Combine API and Local Data
      } else {
        print("Failed to fetch data: ${response.statusCode}");
        throw Exception("Failed to load products");
      }
    } catch (error) {
      print("Error: $error");
      throw Exception("Something went wrong");
    }
  }
}
