import 'package:flutter/material.dart';


class CustomerServices extends StatelessWidget {
  final String title2;

  CustomerServices(this.title2);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text(title2),
        backgroundColor: Colors.amber,
      ),
    );
  }
}
