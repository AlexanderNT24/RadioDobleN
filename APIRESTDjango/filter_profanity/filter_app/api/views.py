from rest_framework.viewsets import ModelViewSet
from filter_app.models import Post
from filter_app.api.serializers import PostSerializers
from spanlp.palabrota import Palabrota

class PostApiViewSet(ModelViewSet):

    serializer_class=PostSerializers   
    queryset=Post.objects.all()