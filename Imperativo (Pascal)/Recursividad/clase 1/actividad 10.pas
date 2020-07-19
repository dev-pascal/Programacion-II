Program project1;
Type
  Lista= ^Nodo;
  Nodo= Record
           Datos: integer;
           Sig: Lista;
        End;
Var
 L: Lista;
 n: integer;

Procedure AgregarAdelante (var L:lista; num:integer);
Var nue:Lista;
  Begin
    New(nue);
    nue^.datos:=num;
    nue^.sig:=L;
    L:=nue;
  End;


Procedure Imprimir (pri:lista);
Begin
   while (pri <> NIL) do begin
     write (pri^.datos, ' ');
     pri:= pri^.sig
  end;
  writeln;
end;

{---Actividad---}
{ejercicio b}
function Maximo(L:lista):integer;
var max:integer;
begin
  if (L=Nil) then
     Maximo:=-1
  else begin
    max:=Maximo(L^.sig);
    if (L^.datos>max) then
       max:=L^.datos;
    Maximo:=max;
  end;
end;
{ejercicio c}
procedure Imprime(L:lista);
begin
  if (L<>nil) then begin
     writeln(L^.datos);
     Imprime(L^.sig);
  end;
end;

begin
 L:=nil;
 randomize;
 n := random (100);
 While (n<>0) do Begin
   AgregarAdelante (L, n);
   n := random (100);
 End;
 writeln ('Lista generada: ');
 imprimir (L);
 writeln('Maximo:');
 writeln(Maximo(L));
 Imprime(L);
 readln
end.
