program repaso2;
type
        fecha=record
                dia:1..31;
                mes:1..12;
                anio:integer;
        end;
        alumno=record
                codigo_alumno:integer;
                nombre_alumno:string;
                codigo_materia:integer;
                examen_final:fecha;
                nota_examen:real;
        end;
        listaNotas=^nodoNota;
        nodoNota=record
            dato:real;
            sig:listaNotas;
        end;
        alumnoArbol=record
            codigo:integer;
            nombre:string;
            notas:listaNotas;
        end;
        arbol=^nodoA;
        nodoA=record
                dato:alumnoArbol;
                HI:arbol;
                HD:arbol;
        end;
year=2000..2019;
alumnos=10000..12000;
// Lista de Arboles
        listaNivel = ^nodoN;
        nodoN = record
              info: arbol;
              sig: listaNivel;
        end;

//Genera alumnos de forma aleatoria
procedure procesarAlumno (var a:alumno);
var
  v:array[1..10] of string;
  n:1..10;
  y:year;
begin
     v[1]:= 'juan';
     v[2]:= 'pedro';
     v[3]:= 'carlos';
     v[4]:= 'julia';
     v[5]:= 'mariana';
     v[6]:= 'gonzalo';
     v[7]:='alejandro';
     v[8]:= 'silvana';
     v[9]:= 'federico';
     v[10]:= 'ruth';
     if (a.codigo_alumno<>0) then begin
        n:=random(10);
        y:=random(2020);
        a.nombre_alumno:=v[n];
        a.codigo_materia:=random(1000);
        a.examen_final.dia:=random(31);
        a.examen_final.mes:=random(12);
        a.examen_final.anio:=y;
        a.nota_examen:=random(11);
     end;
end;
procedure AgregarNota (nota:real; var L:listaNotas);
var aux:listaNotas;
begin
     new(aux);
     aux^.dato:=nota;
     aux^.sig:=L;
     L:=aux;
end;
procedure insertarElem (var a:arbol; alu:alumno);
begin
     if (a=nil) then begin
        new(a);
        a^.dato.codigo:=alu.codigo_alumno;
        a^.dato.nombre:=alu.nombre_alumno;
        a^.dato.notas:=nil;
        a^.HI:=nil;
        a^.HD:=nil;
        agregarNota(alu.nota_examen,a^.dato.notas);
     end
     else
        if (a^.dato.codigo>alu.codigo_alumno) then
           insertarElem(a^.HI,alu)
        else
          if (a^.dato.codigo<alu.codigo_alumno) then
             insertarElem(a^.HD,alu)
          else //ES IGUAL
             agregarNota(alu.nota_examen,a^.dato.notas);
end;
procedure cuentoAlumnos(a:arbol; var cant:integer);
begin
  if (a<>nil) then begin
     cant:=cant+1;
     cuentoAlumnos(a^.HI,cant);
     cuentoAlumnos(a^.HD,cant);
  end;
end;
procedure recorroLista (L:listaNotas; var cant: integer; var notas:real);
begin
     if (L<>nil) then begin
        cant:=cant+1;
        notas:=notas+L^.dato;
        recorroLista(L^.sig,cant,notas);
     end;
end;
procedure recorridoAcotado (a:arbol; inf:integer; sup:integer);
var cant: integer;
  notas,promedio:real;
begin
 if (a<>nil) then
   if (a^.dato.codigo>=inf) then
     if (a^.dato.codigo<=sup) then begin
       cant:=0;
       notas:=0;
       writeln('-----');
       writeln('Nombre de alumno: ', a^.dato.nombre);
       recorroLista(a^.dato.notas,cant,notas);
       promedio:=notas/cant;
       writeln('Promedio: ',promedio:2:2);
       recorridoAcotado(a^.HI,inf,sup);
       recorridoAcotado(a^.HD,inf,sup);
     end
     else
        recorridoAcotado(a^.HI,inf,sup)
   else
     recorridoAcotado(a^.HD,inf,sup)
end;


//programa principal
var alu:alumno; a:arbol; cantAlumnos:integer; code:alumnos; cantidad:integer;
begin
   //inciso A
   code:=random(30000);
   alu.codigo_alumno:=code;
   cantidad:=0;
   while (alu.codigo_alumno<>250000) and (cantidad<>900) do begin
       procesarAlumno(alu);
       insertarElem(a,alu);
       cantidad:=cantidad+1;
       code:=random(30000);
       alu.codigo_alumno:=code;
   end;
   //inciso B
   recorridoAcotado(a,10000,11000);
   //inciso C
   cantAlumnos:=0;
   cuentoAlumnos(a, cantAlumnos);
   writeln;
   writeln('Cantidad de alumnos de la Facultad: ', cantAlumnos);
   readln;
end.
