import 'package:flutter/material.dart';
import 'package:quiz/questions.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
        primarySwatch: Colors.blue,
        // This makes the visual density adapt to the platform that you run
        // the app on. For desktop platforms, the controls will be smaller and
        // closer together (more dense) than on mobile platforms.
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  List<Question> questionBank = [
    Question(
      question: "NMIT is located in Bengaluru",
      answer: true,
    ),
    Question(
      question: "Are you studying at NMIT",
      answer: true,
    ),
    Question(
      question: "Bangalore is located in J&K",
      answer: false,
    ),
    Question(
      question: "Current year is 2020",
      answer: false,
    ),
    Question(
      question: "NMIT is located in Bengaluru",
      answer: true,
    ),
    Question(
      question: "Are you studying at NMIT",
      answer: true,
    ),
    Question(
      question: "Bangalore is located in J&K",
      answer: false,
    ),
    Question(
      question: "Current year is 2020",
      answer: false,
    ),
    Question(
      question: "Bangalore is located in J&K",
      answer: false,
    ),
    Question(
      question: "Current year is 2020",
      answer: false,
    )
  ];

  int currentQuestion = 0;
  int score = 0;
  void checkAnswer(bool value) {
    if (value == questionBank[currentQuestion].answer) {
      setState(() {
        score += 1;
      });

      if (currentQuestion < questionBank.length - 1) {
        setState(() {
          currentQuestion += 1;
        });
      }

      return;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      body: Column(
        children: [
          Expanded(
            flex: 2,
            child: Padding(
              padding: EdgeInsets.all(10),
              child: Center(
                child: Text(
                  questionBank[currentQuestion].question,
                  textAlign: TextAlign.center,
                  style: TextStyle(color: Colors.white),
                ),
              ),
            ),
          ),
          Row(
            children: [
              Expanded(
                child: Center(
                  child: FlatButton(
                    onPressed: () {
                      checkAnswer(true);
                    },
                    child: Text(
                      "True",
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                ),
              ),
              Expanded(
                child: Center(
                  child: FlatButton(
                    onPressed: () {
                      checkAnswer(false);
                    },
                    child: Text(
                      "False",
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                ),
              ),
            ],
          ),
          Expanded(
              child: Container(
            child: Center(
              child: Text(
                '$score',
                style: TextStyle(color: Colors.white, fontSize: 90),
              ),
            ),
          ))
        ],
      ),
    );
  }
}
