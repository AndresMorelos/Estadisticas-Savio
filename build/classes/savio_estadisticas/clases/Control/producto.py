from itertools import combinations

a = ["Tareas","Consultas","Etiquetas","Foros","Chats","Lecciones","Wikis","Bases de datos","Paquetes SCORM","Archivos","URLs","Paginas","Cuestionarios","Talleres","VPL"]

c = list(combinations(a,2))

for x in c:
	print(x)
	pass