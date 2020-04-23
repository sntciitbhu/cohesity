import 'package:flutter/material.dart';


class Settings extends StatelessWidget {
  final String title02;

  Settings(this.title02);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text(title02),
        backgroundColor: Colors.amber,
      ),
    );
  }
}
