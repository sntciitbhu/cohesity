import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'stacked_icons.dart';
import 'home.dart';
import 'main.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:firebase_auth/firebase_auth.dart';

class LoginPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => new _LoginPage();
  }

class _LoginPage extends State<LoginPage>{
  String _email;
  String _password;

  

  @override
  Widget build(BuildContext context) {
    
SystemChrome.setSystemUIOverlayStyle(SystemUiOverlayStyle.dark.copyWith(
  statusBarColor: Colors.amber, //or set color with: Color(0xFF0000FF)
));
    return new Scaffold(
      resizeToAvoidBottomPadding: false,
      appBar: new AppBar(
        backgroundColor:Colors.transparent,
          elevation: 0.0,
          iconTheme: new IconThemeData(color: Colors.amber)),
      body: Container(
        width: double.infinity,
        child: new Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            new StakedIcons(),
            new Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Padding(
                  padding: const EdgeInsets.only(top: 2.0, bottom: 0.0),
                  child: new Text(
                    "Remedi",
                    style: new TextStyle(fontSize: 35.0,fontFamily: 'Pacifico'),
                  ),
                )
              ],
            ),
            Padding(
              padding:
                  const EdgeInsets.symmetric(horizontal: 35.0, vertical: 0.0),
              child: new TextField(
                style: TextStyle(
                  color: Colors.blue,
                  fontSize: 16.0
                ),
                decoration: new InputDecoration(labelText: 'EMAIL',),
                onChanged: (value) {
                  _email = value;
                },
              ),
            ),
            new SizedBox(
              height: 3.0,
            ),
            Padding(
              padding:
                  const EdgeInsets.symmetric(horizontal: 35.0, vertical: 0.0),
              child: new TextField(
                 style: TextStyle(
                  color: Colors.blue,
                  fontSize: 16.0
                ),
                obscureText: true,
                decoration: new InputDecoration(labelText: 'PASSWORD'),
                onChanged: (value) {
                  _password = value;
                },
              ),
            ),
            new Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Expanded(
                  child: Padding(
                    padding: const EdgeInsets.only(
                        left: 120.0, right: 120.0, top: 25.0),
                    child: GestureDetector(
                      onTap: () {
                        FirebaseAuth.instance.signInWithEmailAndPassword(
                          email: _email,
                          password: _password
                        ).then((FirebaseUser user){
                          Navigator.of(context).pop();
                          Navigator.of(context).pushReplacementNamed('/homepage');
                        })
                        .catchError((e){});
                      },
                                          child: new Container(
                            alignment: Alignment.center,
                            height: 50.0,
                            
                            decoration: new BoxDecoration(
                                color: Color(0xFF99AAAB),
                                borderRadius: new BorderRadius.circular(100.0)),
                            child: new Text("Log In",
                                style: new TextStyle(
                                    fontSize: 17.0, color: Colors.white))),
                    ),
                  ),
                ),
                
              ],
            ),
           
            Padding(
              padding:
                  const EdgeInsets.symmetric(horizontal: 20.0, vertical: 10.0),
              child: new GestureDetector(
                onTap: () async {
                  const url='https://facebook.com';
                  if (await canLaunch(url)){
                    await launch(url);
                  } else{
                    throw 'Couldn\'t Lauch $url';
                  }
                },
                child: new Text("Forgot your password?",style: new TextStyle(
                fontSize: 15.0
              ),)
              ),
              ),
            
            Expanded(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.end,
                children: <Widget>[
                  Padding(
                    padding: const EdgeInsets.only(bottom:25.0),
                    child: new GestureDetector(
                      onTap: () {
                        Navigator.of(context).pushNamed('/signup');
                      },
                    child: new Text("New Member? Sign Up",style: new TextStyle(
                                fontSize: 17.0, color: Colors.amber)),
                    ),
                  ),
                ],
              ),
            )
          ],
        ),
      ),
    );
  }

  
}
