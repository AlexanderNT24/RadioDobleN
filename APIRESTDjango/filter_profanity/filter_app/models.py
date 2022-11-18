from django.db import models
from django.db.models.fields import DateField
import datetime
from spanlp.palabrota import Palabrota

class Post(models.Model):
    title=models.CharField(max_length=255)
    content=models.TextField()
