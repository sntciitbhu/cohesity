import 'package:flutter/material.dart';
import 'login.dart';
import 'doctornear.dart';
import 'previoushealth.dart';
import 'customerservices.dart';
import 'signuppage.dart';
import 'home.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'chatbot.dart';

void main() => runApp(Remedi());

class Remedi extends StatelessWidget {
  
 
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Remedi',
      debugShowCheckedModeBanner: false,
      // Set Raleway as the default app font
      theme: ThemeData(
        fontFamily: 'SegoeUI',
      ),

      home: MyHomePage(),
      routes: <String,WidgetBuilder>{
        "/a": (BuildContext context) => new DoctorsNear("Doctors Near You"),
        "/b": (BuildContext context) => new PreviousHealthIssue("Previous Health Issue"),
         "/c": (BuildContext context) => new DoctorsNear("Settings"),
         "/d": (BuildContext context) => new CustomerServices("Customer Services"),
         "/signup" : (BuildContext context) => new SignUpPage(),
         "/homepage": (BuildContext context)=> new HomePage(),
         "/main" : (BuildContext context) => new Remedi(),
         "/e": (BuildContext context) => new ChatBot("Fix An Appointment"),
      }
    );
  }
}

class MyHomePage extends StatefulWidget {

  @override
  _MyHomePage createState() => _MyHomePage();
}
  class _MyHomePage extends State<MyHomePage>{

    final GoogleSignIn _googleSignIn = GoogleSignIn();
    final FirebaseAuth _auth = FirebaseAuth.instance;
    void signInWithGoogle() async {
        final GoogleSignInAccount googleUser = await _googleSignIn.signIn();
        final GoogleSignInAuthentication googleAuth =
            await googleUser.authentication;
        final AuthCredential credential = GoogleAuthProvider.getCredential(
          accessToken: googleAuth.accessToken,
          idToken: googleAuth.idToken,
        );
        final FirebaseUser user = await _auth.signInWithCredential(credential);
        assert(user.email != null);
        assert(user.displayName != null);
        assert(!user.isAnonymous);
        assert(await user.getIdToken() != null);

        final FirebaseUser currentUser = await _auth.currentUser();
        assert(user.uid == currentUser.uid);

        Navigator.of(context).pushReplacementNamed('/homepage');
      }
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            new Stack(
              alignment: Alignment.center,
              children: <Widget>[
                new Container(
                  height: 60.0,
                  width: 60.0,
                  decoration: new BoxDecoration(
                      borderRadius: new BorderRadius.circular(50.0),
                      color: Colors.amber),
                  child: new Icon(
                    Icons.place,
                    color: Colors.white,
                  ),
                ),
                new Container(
                  margin: new EdgeInsets.only(right: 48.0, top: 92.0),
                  height: 60.0,
                  width: 60.0,
                  decoration: new BoxDecoration(
                      borderRadius: new BorderRadius.circular(50.0),
                      color: Colors.amber),
                  child: new Icon(
                    Icons.local_taxi,
                    color: Colors.white,
                  ),
                ),
                new Container(
                  margin: new EdgeInsets.only(left: 48.0, top: 92.0),
                  height: 60.0,
                  width: 60.0,
                  decoration: new BoxDecoration(
                      borderRadius: new BorderRadius.circular(50.0),
                      color: Colors.amber),
                  child: new Icon(
                    Icons.local_hospital,
                    color: Colors.white,
                  ),
                ),
                
              ],
            ),
            new Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Padding(
                  padding: const EdgeInsets.only(top: 2.0, bottom: 45.0),
                  child: new Text(
                    "Remedi",
                    style: new TextStyle(fontSize: 35.0, fontFamily: 'Pacifico'),
                  ),
                )
              ],
            ),
            SizedBox(height: 50,),
            new Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Expanded(
                  child: Padding(
                    padding: const EdgeInsets.only(
                        left: 120.0, right: 120.0, top: 2.0),
                    child: GestureDetector(
                      onTap: () {
                         Navigator.push(context, MaterialPageRoute(
                           builder: (context) => LoginPage(),
                         ));
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
                )
              ],
            ),
            
        SizedBox(
          height: 40.0,
        ),

        new Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Expanded(
                  child: Padding(
                    padding: const EdgeInsets.only(
                        left: 20.0, right: 15.0),
                    child: new Container(
                        alignment: Alignment.center,
                        height: 0.5,
                        decoration: new BoxDecoration(
                            color: Color(0xFF2C3335),
                            ),
                        ),
                  ),
                ),
                new Text('OR'),
                Expanded(
                  child: Padding(
                    padding: const EdgeInsets.only(
                        left: 15.0, right: 20.0),
                    child: new Container(
                        alignment: Alignment.center,
                        height: 0.5,
                        decoration: new BoxDecoration(
                            color: Color(0xFF2C3335),
                            ),
                       ),
                  ),
                )
              ],
            ),
        
        SizedBox(
          height: 50.0,
        ),
        IntrinsicHeight(
                  child: new Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Image.asset('images/facebook.png',
              height: 55.0),
              VerticalDivider(color: Color(0xFF2C3335),width: 40.0,),
              new GestureDetector(
                onTap: (){
                  signInWithGoogle();
                },
              
                
              child: new Image.asset('images/google-plus.png',
              height: 55.0)
              )
            ],
          ),
        )
          ],
        ),
      ),
    );
  }
}
