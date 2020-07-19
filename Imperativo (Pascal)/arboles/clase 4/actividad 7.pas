Program 4Act7;
Type

  // Lista de enteros
  lista = ^nodoL;
  nodoL = record
    dato: integer;
    sig: lista;
  end;

  // Arbol de enteros
  arbol= ^nodoA;
  nodoA = Record
    dato: integer;
    HI: arbol;
    HD: arbol;
  End;

  // Lista de Arboles
  listaNivel = ^nodoN;
  nodoN = record
    info: arbol;
    sig: listaNivel;
  end;


{-----------------------------------------------------------------------------
AgregarAdelante - Agrega nro adelante de l}
procedure agregarAdelante(var l: Lista; nro: integer);
var
  aux: lista;
begin
  new(aux);
  aux^.dato := nro;
  aux^.sig := l;
  l:= aux;
end;



{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista con números aleatorios }
procedure crearLista(var l: Lista);
var
  n: integer;
begin
 l:= nil;
 n := random (20);
 While (n <> 0) do Begin
   agregarAdelante(L, n);
   n := random (20);
 End;
end;


{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista(l: Lista);
begin
 While (l <> nil) do begin
   write(l^.dato, ' - ');
   l:= l^.sig;
 End;
end;

{-----------------------------------------------------------------------------
CONTARELEMENTOS - Devuelve la cantidad de elementos de una lista l }

function ContarElementos (l: listaNivel): integer;
  var c: integer;
begin
 c:= 0;
 While (l <> nil) do begin
   c:= c+1;
   l:= l^.sig;
 End;
 contarElementos := c;
end;


{-----------------------------------------------------------------------------
AGREGARATRAS - Agrega un elemento atrás en l}

Procedure AgregarAtras (var l, ult: listaNivel; a:arbol);
 var nue:listaNivel;

 begin
 new (nue);
 nue^.info := a;
 nue^.sig := nil;
 if l= nil then l:= nue
           else ult^.sig:= nue;
 ult:= nue;
 end;
{Actividad}
procedure Insertar(num:integer; var a:arbol);
begin
  if (a=nil) then begin
     new(a);
     a^.dato:=num;
     a^.HI:=nil;
     a^.HD:=nil;
  end
  else
    if (a^.dato>num) then
       Insertar(num,a^.HI)
    else
      if (a^.dato<num) then
       Insertar(num,a^.HD)
end;

procedure InsertarElementos (L:lista; var a:arbol);
begin
   if (L<>nil) then begin
      Insertar(L^.dato,a);
      InsertarElementos(L^.sig,a);
   end;
end;

Procedure enOrden( a: arbol );
begin
  if ( a <> nil ) then begin
  enOrden (a^.HI);
  write (a^.dato, '   ');
  enOrden (a^.HD)
  end;
end;

procedure VerValoresEnRango ( a:arbol; inf:integer; sup:integer);
begin
 if (a<>nil) then
   if(a^.dato>=inf)then
     if(a^.dato<=sup)then begin
       write(a^.dato;' - ');
       VerValoresEnRango(a^.HI,inf,sup);
       VerValoresEnRango(a^.HD,inf,sup);
     end
     else
       VerValoresEnRango(a^.HI,inf,sup)
     else
       VerValoresEnRango(a^.HD,inf,sup)
   end;


{-----------------------------------------------------------------------------
IMPRIMIRPORNIVEL - Muestra los datos del árbol a por niveles }

Procedure imprimirpornivel(a: arbol);
var
   l, aux, ult: listaNivel;
   nivel, cant, i: integer;
begin
   l:= nil;
   if(a <> nil)then begin
                 nivel:= 0;
                 agregarAtras (l,ult,a);
                 while (l<> nil) do begin
                    nivel := nivel + 1;
                    cant:= contarElementos(l);
                    write ('Nivel ', nivel, ': ');
                    for i:= 1 to cant do begin
                      write (l^.info^.dato, ' - ');
                      if (l^.info^.HI <> nil) then agregarAtras (l,ult,l^.info^.HI);
                      if (l^.info^.HD <> nil) then agregarAtras (l,ult,l^.info^.HD);
                      aux:= l;
                      l:= l^.sig;
                      dispose (aux);
                     end;
                     writeln;
                 end;
               end;
end;


Var

 l: lista;
 a:arbol;
 inf,sup:integer;
begin
 Randomize;

 crearLista(l);
 writeln ('Lista generada: ');
 imprimirLista(l);
 InsertarElementos(L,a);
 enOrden(a);
 writeln('Informar Rango: ');
 readln(inf);
 readln(sup);
 VerValoresEnRango(a,inf,sup);
 readln;
end.
