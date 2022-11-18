from rest_framework.serializers import ModelSerializer
from filter_app.models import Post

class PostSerializers(ModelSerializer):
    class Meta:
        model = Post
        fields=['id','title','content']

