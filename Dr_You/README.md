# DrYOU
This is a medical website for Hack Out event under Technex 2020

## Team Name:
<b> scratta_du_fluorar_du</b>

Members:
- Pankaj Yadav
- Chirag Agarwal

### Features:
- Registration and Login
- MediQuora (A place where people can share experiences and give advice to a large community)
- Health Manager (Where people can keep track of their health)
- Chat with AI<br>
We have deployed microsoft Health Bot Service which implements natural language understanding (NLP) and artificial intelligence (AI) technologies to understand the users' intent and provide accurate information. This is highly customizible and extensible. We plan to use this in combination with MediQuora and Health Manager to provide the users highly reliable and accurate diagnosis so as to give early warnings as well as save time of going to hospitals for trivial diagnosis. [Link](https://docs.microsoft.com/en-us/healthbot/) for more information 

## Features tried to include:
- Use of external API
- Minifications (as best as we could)
- Tensorflow JS (In Health Manager for predicting Sugar Levels although the model is not so good as of now)
- Use of Data Vizualization Librariers (Matplotlib and Chart.js)
- Proper app deployment on cloud server ([link](http://dryou.herokuapp.com/))
- Isomorphic (Tensorflow.JS as the entire model is run on the browser itself) 

## How to use:
All dependencies are listed in requirements.txt<br>
In the health manager you can add your sugar levels and blood pressure to get interactive vizualizations. Blogs can be written using write blog feature and tags can be used to filter the blogs. The Chat option redicts to microsoft Health Bot service which is deployed on azure.

 
