Program arboles;

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




{-----------------------------------------------------------------------------
AGREGARATRAS - Agrega un elemento atrás en l}




{-----------------------------------------------------------------------------
IMPRIMIRPORNIVEL - Muestra los datos del árbol a por niveles }

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
       write(a^.dato,' - ');
       VerValoresEnRango(a^.HI,inf,sup);
       VerValoresEnRango(a^.HD,inf,sup);
     end
     else
       VerValoresEnRango(a^.HI,inf,sup)
     else
       VerValoresEnRango(a^.HD,inf,sup)
   end;


procedure borrarElemento (var a:arbol; num:integer; var resultado:boolean);
   procedure buscoMinimo (a: arbol; var minimo: integer);
   begin
     if (a^.HI=nil) then
       minimo:=a^.dato
     else
       buscoMinimo(a^.HI,minimo);
   end;
var minimo:integer; aux:arbol;
begin
   if (a<>nil) then begin
     if (a^.dato>num) then
        borrarElemento(a^.HI, num, resultado)
     else
       if (a^.dato<num) then
          borrarElemento(a^.HD, num, resultado)
       else begin
         resultado:=true;
         if (a^.HD=nil) then begin
            aux:=a;
            a:=a^.HI;
            dispose(aux);
         end
         else begin
           if (a^.HI=nil) then begin
              aux:=a;
              a:=a^.HD;
              dispose(aux);
           end
           else begin
             minimo:=9999;
             buscoMinimo(a^.HD,minimo);
             a^.dato:=minimo;
             borrarElemento(a^.HD,a^.dato,resultado);
           end;
         end;
      end;
   end;
end;



Var

 l: lista;
 a:arbol;
 num:integer;
 resultado:boolean;

begin
 Randomize;

 crearLista(l);
 writeln ('Lista generada: ');
 imprimirLista(l);
 insertarElementos(l,a);
 imprimirpornivel(a);
 readln(num);
 resultado:=false;
 borrarElemento(a,num,resultado);
 writeln(resultado);
 imprimirpornivel(a);
 readln;
end.
