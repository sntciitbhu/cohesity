from django.urls import reverse_lazy
from django.views import generic
from django.contrib.auth import login, authenticate
from django.contrib.auth.forms import UserCreationForm
from django.shortcuts import render, redirect


class SignUp(generic.CreateView):
    form_class = UserCreationForm
    success_url = reverse_lazy('login')
    template_name = 'signup.html'


def signup(request):
    if request.method == 'POST':
        form = UserCreationForm(request.POST)
        if form.is_valid():
            form.save()
            username = form.cleaned_data.get('username')
            raw_password = form.cleaned_data.get('password1')
            user = authenticate(username=username, password=raw_password)
            login(request, user)
            return redirect('home')
        else:
            return render(request, 'rules.html')
    else:
        form = UserCreationForm()
    return render(request, 'signup.html', {'form': form})


'''
<form method="POST" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="id_username"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="username" maxlength="150" autofocus="" required="" id="id_username" placeholder="Your Username"/>
                            </div>
                            <div class="form-group">
                                <label for="id_password1"><i class="zmdi zmdi-email"></i></label>
                                <input type="password" name="password1" required="" id="id_password1" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <label for="id_password2"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password2" required="" id="id_password2" placeholder="Confirm Password"/>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                            </div>
                        </form>
'''





'''
{% extends 'base.html' %}

{% block content %}
<center>
  <h2>Sign up</h2>
  <form style="align-" method="post">
    {% csrf_token %}
    {{ form.as_p }}
    <button type="submit">Sign up</button>
  </form>

    </center>
{% endblock %}
'''
'''

<label for="id_username">Username:</label>
<br>
<input type="text" name="username" maxlength="150" autofocus="" required="" id="id_username">
<small style="color: grey">Required. 150 characters or fewer. Letters, digits and @/./+/-/_ only.</small>
<label for="id_password1">Password:</label>
<br>
<input type="password" name="password1" required="" id="id_password1">



< p >
< label
for ="id_username" > Username:< / label > < br >
< input
type = "text"
name = "username"
maxlength = "150"
autofocus = ""
required = ""
id = "id_username" >

< small
style = "color: grey" > Required.
150
characters or fewer.Letters, digits and


@

/./ + / - / _
only. < / small >

< / p >

< p >
< label
for ="id_password1" > Password:< / label > < br >
< input
type = "password"
name = "password1"
required = ""
id = "id_password1" >

< small
style = "color: grey" > < / small > < / p > < ul > < li > < small
style = "color: grey" > Your
password
can
't be too similar to your other personal information.</small></li><li><small style="color: grey">Your password must contain at least 8 characters.</small></li><li><small style="color: grey">Your password can'
t
be
a
commonly
used
password. < / small > < / li > < li > < small
style = "color: grey" > Your
password
can
't be entirely numeric.</small></li></ul>

< p > < / p >

< p >
< label
for ="id_password2" > Password confirmation:< / label > < br >
< input
type = "password"
name = "password2"
required = ""
id = "id_password2" >

< small
style = "color: grey" > Enter
the
same
password as before,
for verification. </ small >

< / p >

< button
type = "submit" > Sign
up < / button >
< / form >


'''
'''
<form method="post">
                            {% csrf_token %}
                            {% for field in form %}
                              <p>
                                {{ field.label_tag }}<br>
                                {{ field }}
                                {% if field.help_text %}
                                  <small style="color: grey">{{ field.help_text }}</small>
                                {% endif %}
                                {% for error in field.errors %}
                                  <p style="color: red">{{ error }}</p>
                                {% endfor %}
                              </p>
                            {% endfor %}
                            <button type="submit">Sign up</button>
                          </form>

'''

'''
LOGIN



<form method="POST" class="post-form"><input type="hidden" name="csrfmiddlewaretoken" value="zXun0u8tLM3NizFemRf0LWUAQlymGJSGvR1ayFG4zx71EQsDmQEczQFzGA6gWTi1">
        <label for="id_username">Username:</label><input type="text" name="username" autofocus="" required="" id="id_username">
<label for="id_password">Password:</label><input type="password" name="password" required="" id="id_password">
        <button type="submit" class="save btn btn-default">Save</button>
    </form>




'''


'''

<form method="POST" class="register-form" id="login-form">
                            {% csrf_token %}
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="your_name" id="your_name" placeholder="Your Username"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="your_pass" id="your_pass" placeholder="Password"/>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                            </div>
                        </form>

'''