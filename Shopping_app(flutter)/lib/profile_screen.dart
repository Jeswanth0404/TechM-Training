import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class ProfileScreen extends StatefulWidget {
  @override
  _ProfileScreenState createState() => _ProfileScreenState();
}

class _ProfileScreenState extends State<ProfileScreen> {
  final FirebaseAuth _auth = FirebaseAuth.instance;
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;
  final _formKey = GlobalKey<FormState>();

  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();
  final TextEditingController nameController = TextEditingController();

  bool isLogin = true; // Toggle between Login & Register
  User? _user;

  @override
  void initState() {
    super.initState();
    _user = _auth.currentUser; // Check if user is already logged in
  }

  void login() async {
    if (_formKey.currentState!.validate()) {
      try {
        UserCredential userCredential = await _auth.signInWithEmailAndPassword(
          email: emailController.text,
          password: passwordController.text,
        );
        setState(() {
          _user = userCredential.user; // Update UI after login
        });
      } catch (e) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text("Login failed: $e")),
        );
      }
    }
  }

  void register() async {
    if (_formKey.currentState!.validate()) {
      try {
        UserCredential userCredential = await _auth.createUserWithEmailAndPassword(
          email: emailController.text,
          password: passwordController.text,
        );

        // Save user data to Firestore
        await _firestore.collection("users").doc(userCredential.user!.uid).set({
          "name": nameController.text,
          "email": emailController.text,
        });

        setState(() {
          _user = userCredential.user;
        });

        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text("Registration successful!")),
        );
      } catch (e) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text("Registration failed: $e")),
        );
      }
    }
  }

  void logout() async {
    await _auth.signOut();
    setState(() {
      _user = null;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Profile")),
      body: _user == null
          ? Padding(
              padding: EdgeInsets.all(16.0),
              child: Form(
                key: _formKey,
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text(
                      isLogin ? "Login to Order" : "Register as a New User",
                      style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                    ),
                    SizedBox(height: 20),
                    if (!isLogin)
                      TextFormField(
                        controller: nameController,
                        decoration: InputDecoration(labelText: "Full Name"),
                        validator: (value) => value!.isEmpty ? "Enter your name" : null,
                      ),
                    TextFormField(
                      controller: emailController,
                      decoration: InputDecoration(labelText: "Email"),
                      validator: (value) => value!.isEmpty ? "Enter your email" : null,
                    ),
                    TextFormField(
                      controller: passwordController,
                      decoration: InputDecoration(labelText: "Password"),
                      obscureText: true,
                      validator: (value) => value!.isEmpty ? "Enter your password" : null,
                    ),
                    SizedBox(height: 20),
                    ElevatedButton(
                      onPressed: isLogin ? login : register,
                      child: Text(isLogin ? "Login" : "Register"),
                    ),
                    TextButton(
                      onPressed: () {
                        setState(() {
                          isLogin = !isLogin; // Toggle between Login & Register
                        });
                      },
                      child: Text(isLogin ? "New User? Register Here" : "Already Registered? Login"),
                    ),
                  ],
                ),
              ),
            )
          : Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text("Welcome, ${_user!.email}", style: TextStyle(fontSize: 18)),
                  SizedBox(height: 20),
                  ElevatedButton(
                    onPressed: logout,
                    child: Text("Logout"),
                  ),
                ],
              ),
            ),
    );
  }
}
