// File generated by FlutterFire CLI.
// ignore_for_file: type=lint
import 'package:firebase_core/firebase_core.dart' show FirebaseOptions;
import 'package:flutter/foundation.dart'
    show defaultTargetPlatform, kIsWeb, TargetPlatform;

/// Default [FirebaseOptions] for use with your Firebase apps.
///
/// Example:
/// ```dart
/// import 'firebase_options.dart';
/// // ...
/// await Firebase.initializeApp(
///   options: DefaultFirebaseOptions.currentPlatform,
/// );
/// ```
class DefaultFirebaseOptions {
  static FirebaseOptions get currentPlatform {
    if (kIsWeb) {
      return web;
    }
    switch (defaultTargetPlatform) {
      case TargetPlatform.android:
        return android;
      case TargetPlatform.iOS:
        return ios;
      case TargetPlatform.macOS:
        return macos;
      case TargetPlatform.windows:
        return windows;
      case TargetPlatform.linux:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for linux - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      default:
        throw UnsupportedError(
          'DefaultFirebaseOptions are not supported for this platform.',
        );
    }
  }

  static const FirebaseOptions web = FirebaseOptions(
    apiKey: 'AIzaSyAAIftnvwsbuZFJD4yVrv0-lEXEa1frwU4',
    appId: '1:152924464962:web:178a88a09b17cf34318adb',
    messagingSenderId: '152924464962',
    projectId: 'flutterapp-fcc83',
    authDomain: 'flutterapp-fcc83.firebaseapp.com',
    storageBucket: 'flutterapp-fcc83.firebasestorage.app',
    measurementId: 'G-C1DW1KNGZP',
  );

  static const FirebaseOptions android = FirebaseOptions(
    apiKey: 'AIzaSyBIz2JwL2zhI7u8DdaTq_fVcvw3HuksbBQ',
    appId: '1:152924464962:android:17a6b8c0a0afc399318adb',
    messagingSenderId: '152924464962',
    projectId: 'flutterapp-fcc83',
    storageBucket: 'flutterapp-fcc83.firebasestorage.app',
  );

  static const FirebaseOptions ios = FirebaseOptions(
    apiKey: 'AIzaSyDYVaYCjcqgjtDXopY8MzoCWj_Yz-4enzc',
    appId: '1:152924464962:ios:ac9470ed31ec8154318adb',
    messagingSenderId: '152924464962',
    projectId: 'flutterapp-fcc83',
    storageBucket: 'flutterapp-fcc83.firebasestorage.app',
    iosBundleId: 'com.example.shoppingApp',
  );

  static const FirebaseOptions macos = FirebaseOptions(
    apiKey: 'AIzaSyDYVaYCjcqgjtDXopY8MzoCWj_Yz-4enzc',
    appId: '1:152924464962:ios:ac9470ed31ec8154318adb',
    messagingSenderId: '152924464962',
    projectId: 'flutterapp-fcc83',
    storageBucket: 'flutterapp-fcc83.firebasestorage.app',
    iosBundleId: 'com.example.shoppingApp',
  );

  static const FirebaseOptions windows = FirebaseOptions(
    apiKey: 'AIzaSyAAIftnvwsbuZFJD4yVrv0-lEXEa1frwU4',
    appId: '1:152924464962:web:178a88a09b17cf34318adb',
    messagingSenderId: '152924464962',
    projectId: 'flutterapp-fcc83',
    authDomain: 'flutterapp-fcc83.firebaseapp.com',
    storageBucket: 'flutterapp-fcc83.firebasestorage.app',
    measurementId: 'G-C1DW1KNGZP',
  );

}