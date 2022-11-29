from flask import Flask, make_response,jsonify,request
from spanlp.palabrota import Palabrota
palabrota = Palabrota()
#http://192.168.1.96:8000/?sentence=hola%20a%20todos
app=Flask(__name__)
   
@app.route("/")
def filtro(): 
    sentence = request.args.get('sentence')
    print(sentence)
    return jsonify(IsVulgarity=palabrota.contains_palabrota(sentence))

@app.errorhandler(404)
def not_found(e):
    return make_response(jsonify(error='No encontrado'), 404)    

if __name__ == '__main__':
   app.run(host='0.0.0.0', port=8000, debug=True)
