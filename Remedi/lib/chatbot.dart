import 'package:flutter/material.dart';



class ChatBot extends StatelessWidget {
  final String title05;

  ChatBot(this.title05);

  @override
  Widget build(BuildContext context) {
    
    return Scaffold(
      appBar: new AppBar(
        title: new Text(title05),
        backgroundColor: Colors.amber,
      ),
      body: Container(
        
      height: 100.0,
      margin: const EdgeInsets.all(15.0),
      decoration: new BoxDecoration(
        shape: BoxShape.rectangle,
        color: Colors.amberAccent,
        
        borderRadius:BorderRadius.circular(4.0),
        boxShadow: <BoxShadow>[
          new BoxShadow(
            color: Colors.black12,
            offset: new Offset(0.0, 10.0),
            blurRadius: 10.0
          )
        ]
      )
    ),
    );
  }
}
