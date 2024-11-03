from flask import Blueprint, abort, request, render_template, redirect, flash
import requests  # Asegúrate de que "requests" esté correctamente importado
import json
router = Blueprint('router', __name__)

@router.route('/')
def home():
    r = requests.get("http://localhost:8080/api/censo/listCombustible")
    data = r.json()
    print(r.json())
    return render_template('base.html', lista = data["data"])



@router.route('/admin/family/register')
def family_register():
    r = requests.get("http://localhost:8080/api/censo/listCombustible")
    data = r.json()
    print(r.json())
    return render_template('fragmento/Familia/registro.html', lista = data["data"])



@router.route('/admin/family/list')
def family_list():
    r = requests.get("http://localhost:8080/api/censo/list")
    data = r.json()
    print(r.json())
    return render_template('fragmento/Familia/lista.html', lista = data["data"])


@router.route('/admin/family/edit/<id>')
def view_edit_person(id):
    r = requests.get("http://localhost:8080/api/censo/listCombustible")
    data = r.json()
    r1 = requests.get("http://localhost:8080/api/censo/get/"+ id)
    data1 = r1.json()
    if(r1.status_code == 200):
        return render_template('fragmento/Familia/editar.html', lista = data["data"], person = data1["data"])
    else:
        flash(data=["data"], category='error')
        return redirect('/admin/family/list')





@router.route('/admin/family/save', methods=['POST'])
def save_family():
    headers = {'Content-Type': 'application/json'}
    form = request.form

    dataF = {"apellido":form["apellido"],"direccion":form["direccion"],"telefono":form["telefono"],"uso":form["uso"],"combustible":form["combustible"],"consumo":form["consumo"],
             "costo":form["costo"],"energia_generada_KW":form["energia_generada_KW"]}
    r = requests.post('http://localhost:8080/api/censo/save', data=json.dumps(dataF), headers=headers)

    dat = r.json()
    if r.status_code == 200:
        flash("Registro guardado correctamente", category='success')
        return redirect('/admin/family/list')
    else:
        flash(str(dat["data"], category='error')) 
        return redirect('/admin/family/register')
    


@router.route('/admin/family/update', methods=['POST'])
def update_family():
    headers = {'Content-Type': 'application/json'}
    form = request.form

    dataF = {"id":form["id"],"apellido":form["apellido"],"direccion":form["direccion"],"telefono":form["telefono"],"uso":form["uso"],"combustible":form["combustible"],"consumo":form["consumo"],
             "costo":form["costo"],"energia_generada_KW":form["energia_generada_KW"]}
    r = requests.post('http://localhost:8080/api/censo/update', data=json.dumps(dataF), headers=headers)

    dat = r.json()
    if r.status_code == 200:
        flash("Registro guardado correctamente", category='success')
        return redirect('/admin/family/list')
    else:
        flash(str(dat["data"], category='error')) 
        return redirect('/admin/family/regoster')