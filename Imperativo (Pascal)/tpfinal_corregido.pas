Program tpfinal_corregido;
Uses
	sysutils;
Type
	sub = 1..4;
	
	disciplina = record
		cod: integer;
		codDisciplina: integer;
		nombreDisciplina: string;
		puesto: sub;
		nombreAtleta: string;
		pais: string;
	end;

	listaDisciplinas = ^nodoLista;
	nodoLista = record
		dato: disciplina;
		sig: listaDisciplinas;
	end;
        listaPaises = ^nodoPais;
        nodoPais = record
                 dato:string;
                 sig:listaPaises;
        end;
        disciplinaDato = record
           codigo: integer;
           nombre: string;
           cant_atletas: integer;
           paises: listaPaises;
        end;

        arbol= ^nodoA;
         nodoA = Record
           dato: disciplinaDato;
           HI: arbol;
           HD: arbol;
         End;
	
{-----------------------------------------------------------------------------
AgregarOrdenado - Agrega ordenado en l}
Procedure agregarOrdenado(var l: listaDisciplinas; d: disciplina); 
var
   nuevo, anterior, actual: listaDisciplinas;
begin
	new (nuevo);
	nuevo^.dato:= d;
	nuevo^.sig := nil;

	actual := l;
	anterior := l;
	while (actual<>nil) and (actual^.dato.pais < nuevo^.dato.pais) do begin
	   anterior := actual;
	   actual:= actual^.sig;
	end;
	if (anterior = actual) then
	   l := nuevo
	else
	   anterior^.sig := nuevo;
	nuevo^.sig := actual;
end;

{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista }
procedure crearLista(var l: listaDisciplinas);
var
  aux: integer;
  d: disciplina;
begin
  l:= nil;
  d.cod := random (100);
 
  while (d.cod <> 0) do Begin
        aux:=random(193)+1;
        if(aux<10)then
            d.pais:= Concat('Pais00',IntToStr(aux))
        else
            if(aux<100)then
                d.pais:= Concat('Pais0',IntToStr(aux))
	    else
                d.pais:= Concat('Pais',IntToStr(aux));
	d.codDisciplina:= random (299)+1;
	d.nombreDisciplina:= Concat('Disciplina', IntToStr(d.codDisciplina));
	d.puesto:= random (3)+1;
	d.nombreAtleta:= Concat('Atleta', IntToStr(random(5000)));
	agregarOrdenado(l,d);
	d.cod := random (100);
  end;
end;
{Actividad a}
procedure agregarArbol(l:listaDisciplinas; var a:arbol);
var aux:listaDisciplinas;
begin
   aux:=l;
   while (aux<>nil) do begin
      Insertar(l^.dato,a);
      aux:=aux^.sig;
   end;
end;

procedure agregarPais(var l: listaPaises; pais:string);
var
   aux: listaPaises;
begin
     new(aux);
     aux^.dato := pais;
     aux^.sig := l;
     l:= aux;
end;

procedure Insertar(d:disciplina; var a:arbol);
begin
  if (a=nil) then begin
     new(a);
     a^.dato.codigo:=d.codigoDisciplina;
     a^.dato.nombre:=d.nombreAtleta;
     a^.dato.cant_atletas:=1;
     a^.dato.paises:=nil;
     agregarPais(a^.dato.paises,d.pais);
     a^.HI:=nil;
     a^.HD:=nil;
  end
  else
    if (a^.dato>d.codigoDisciplina) then
       Insertar(d,a^.HI)
    else
      if (a^.dato<d.codigoDisciplina) then
       Insertar(d,a^.HD)
      else begin{Es igual.}
        a^.dato.cant_atletas:=a^.dato.cant_atletas+1;
        if (a^.dato.paises.dato<>d.pais) then
          agregarPais(a^.dato.paises,d.pais);
      end;
end;
{procesos del ejercicio}
//(inciso b) recorrido acotado en un intervalo de 100 y 200 de codigo de disciplina.
procedure recorridoAcotado (a:arbol; inf:integer; sup:integer; var cant:integer);
begin
 if (a<>nil) then
   if (a^.dato.codigoDisciplina>=inf) then
     if (a^.dato.codigoDisciplina<=sup) then begin
       writeln(a^.dato.cant_atletas);
       recorridoAcotado(a^.HI,inf,sup,cant);
       recorridoAcotado(a^.HD,inf,sup,cant);
     end
     else
        recorridoAcotado(a^.HI,inf,sup,cant)
   else
     recorridoAcotado(a^.HD,inf,sup,cant)
end;
// (inciso c) será un recorrido pos-orden.
procedure recorroArbol (a:arbol);
begin
  if (a<>nil) then begin
     if (a^.dato.cant_atletas>=100) and (a^.dato.cant_atletas<=200) then
       writeln('Nombre de disciplina: ',a^.dato.nombreDisciplina);
     recorroArbol(a^.HI);
     recorroArbol(a^.HD);
  end;
end;
{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista(l: listaDisciplinas);
  procedure imprimir(d:disciplina);
  begin
    writeln(d.codDisciplina);
    writeln(d.nombreDisciplina);
    writeln(d.puesto);
    writeln(d.nombreAtleta);
    writeln(d.pais);
  end;

begin
  while (l <> nil) do begin
   imprimir(l^.dato); //Completar el algoritmo para validar
   l:= l^.sig;
  end;
end;

Var

 l: listaDisciplinas;
 a: arbol;
 cant: integer;

begin
 Randomize;
 
 crearLista(l);
 writeln ('Lista generada: ');
 imprimirLista(l);
 //ejercicio a)
 agregarArbol(l,a);

 // ejercicio b)
 cant:=0;
 recorridoAcotado(a,100,200,cant);
 writeln(cant);

 // ejercicio c)
 recorroArbol(a);
 writeln('Fin del programa');
 readln;
end.
