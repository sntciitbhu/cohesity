from django.shortcuts import render, redirect, HttpResponse
from django.shortcuts import render, HttpResponseRedirect, HttpResponse, redirect
from .forms import DiabetesForm
from matplotlib.backends.backend_agg import FigureCanvasAgg as FigureCanvas
from matplotlib.figure import Figure
import matplotlib.pyplot as plt
import matplotlib
# import matplotlib as plt
from matplotlib.dates import DateFormatter
import datetime
import random
import io
import base64
from .models import Diabetes
from django.contrib.auth.models import User
from .forms import DiabetesForm, BPForm
from django.views.decorators.csrf import csrf_protect
from blog.models import Post
from django.contrib.auth.decorators import login_required


@csrf_protect
def HomePageView(request):
    template_name = 'homepage.html'
    return render(request, template_name)


@login_required
@csrf_protect
def DisplayViewSugar(request):
    fig = Figure()
    canvas = FigureCanvas(fig)
    ax = fig.add_subplot(111)
    x = []
    y = []

    if not request.user.is_authenticated:
        return HttpResponseRedirect('/accounts/login')

    username = request.user.username
    r = User.objects.get(username=username)
    i = 1
    for dia in r.diabetes_set.all():
        x.append(int(i))
        y.append(int(dia.dia_data))
        i = i + 1
    ax.plot(x, y, color='green', marker='o', linestyle='solid', linewidth=2, markersize=12, markerfacecolor='white',
            markeredgecolor='blue')
    ax.set_title('Blood Sugar Levels')
    ax.hlines(100, 0, i, colors='r', linestyles='dashed')
    ax.grid(True)
    ax.set_xlabel('Test number')
    ax.set_ylabel('Sugar Level')
    # canvas.print_figure('test')
    buf = io.BytesIO()
    # canvas = FigureCanvas(fig)
    canvas.print_png(buf)
    data_url = 'data:image/jpg;base64,' + base64.b64encode(buf.getvalue()).decode()
    fig.clear()
    if request.method == 'POST':
        form = DiabetesForm(request.POST)
        if form.is_valid():
            post = form.save(commit=False)
            post.person = request.user
            post.save()

            return HttpResponseRedirect("/sugar_level")

    else:
        form = DiabetesForm()

    return render(request, "graph_sugar.html", {'image': data_url, 'form': form, 'x': x, 'y': y, 'l': i})

@login_required
@csrf_protect
def DisplayViewBP(request):
    fig = Figure()
    canvas = FigureCanvas(fig)
    ax = fig.add_subplot(111)
    x = []
    y = []
    z = []
    if not request.user.is_authenticated:
        return HttpResponseRedirect('/accounts/login')

    username = request.user.username
    r = User.objects.get(username=username)
    i = 1
    for dia in r.bp_set.all():
        x.append(int(i))
        y.append(int(dia.high))
        z.append(int(dia.low))
        i = i + 1
    ax.plot(x, y, color='green', marker='o', linestyle='solid', linewidth=2, markersize=12, markerfacecolor='white',
            markeredgecolor='blue')
    ax.plot(x, z, color='green', marker='o', linestyle='solid', linewidth=2, markersize=12, markerfacecolor='white',
            markeredgecolor='blue')
    ax.set_title('Blood Sugar Levels')
    ax.hlines(120, 0, i, colors='r', linestyles='dashed')
    ax.hlines(80, 0, i, colors='r', linestyles='dashed')
    ax.grid(True)
    ax.set_xlabel('Test number')
    ax.set_ylabel('Blood Pressure')
    # canvas.print_figure('test')
    buf = io.BytesIO()
    # canvas = FigureCanvas(fig)
    canvas.print_png(buf)
    data_url = 'data:image/jpg;base64,' + base64.b64encode(buf.getvalue()).decode()
    fig.clear()
    if request.method == 'POST':
        form = BPForm(request.POST)
        if form.is_valid():
            post = form.save(commit=False)
            post.patient = request.user
            post.save()

            return HttpResponseRedirect("/blood_pressure")

    else:
        form = BPForm()

    return render(request, "bp.html", {'image': data_url, 'form': form})


@csrf_protect
def BaseView(request):
    return render(request, template_name='base.html')

