# Short description about the app and the idea behind it:-
App name is relief.

1. This app connects User(Patient) with Doctor who is specialized in the field by which patient is suffering
2. For user ==> User(patient) has to register to this app to use any functionality of this app.
3. For Doctor ==> Doctor has to register to this app to provide consultancy to the User(patient) and make money from this. Only registered doctors are available to provide consultancy to the User(patient) about the disease.

4. Consult with the doctor through chat without any hassles at your convenience such as without appointment booking.
5. It featured interactive interface to chat with Doctor and ask for solution to User's problems. This app uses secure chat to answer User's health query.
6. It includes a robust feature because of that Male patients can only consult with Male Doctors and Female patients can only contact to Female Doctors and vice versa.
7. It includes a store from which User(patient) can buy medicines online using Credit card, Debit card or Net banking secured by PayTm and the medicines will be delivered at User's doorstep.
8. User(patient) have to recharge his/her account with Money to consult with Doctors.
9. It will include a feature by which Money acquired by providing a satisfied consulting will credited into the Doctor's account.


# For running into you machine, Make a django environment according to your operating system(given commands are for linux based OS):-

# If you are facing problem intalling pycrypto in windows(due to visual c++ dependency) then run this app into linux it worked well in linux.

1. sudo apt-get install python3
2. sudo apt-get install python3-pip
3. sudo apt-get install virtualenv
4. virtualenv -p python3 venv (name of virtual environment venv)
5. source venv/bin/activate
6. Extract zip file.
7. open terminal inside relieve(Extracted folder)
8. pip install -r requirements.txt 
9. python manage.py makemigrations
10. python manage.py migrate
11. python manage.py runserver

## Home page URL = 'http://13.234.93.154:8000/'  (VISIT HERE)  


# For Viewing or testing Chat feature of this app you have to open two incognito window  (by which user and doctor are logged in without any session mixing problem):-
1. In first window User(patient) have to registered and logged in.
2. In second window Doctor have to registered and logged in.

For chat testing :-
##### Login credentials for user: 
username = usera

password = !@#$%^&*

##### Login credentials for doctor: 
username = doctora

password = !@#$%^&*

then chat can happen between Doctor and User(patient)

## google oauth 2.0 will not work on 'http://13.234.93.154:8000/' but works locally (localhost).

## email activation feature for registration may not work on given link ('http://13.234.93.154:8000/') due to google security issues but works locally

For paytm payment gateway:-

USERNAME: test

PASSWORD: test

Bank: andhra bank
