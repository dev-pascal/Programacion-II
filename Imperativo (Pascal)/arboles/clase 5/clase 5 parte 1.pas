Program clase5;
Type

   encomienda = record
                  codigo: integer;
                  peso: integer;
                end;

  // Lista de encomiendas
  lista = ^nodoL;
  nodoL = record
    dato: encomienda;
    sig: lista;
  end;

  listaCodigos=^nodoC;
  nodoC=record
    dato: integer;
    sig: listaCodigos;
  end;

  arbol = ^nodo;

  nodo = record
    elem: integer;
    codigos: listaCodigos;
    HI: arbol;
    HD: arbol;
  end;

{-----------------------------------------------------------------------------
AgregarAdelante - Agrega una encomienda adelante en l}
procedure agregarAdelante(var l: Lista; enc: encomienda);
var
  aux: lista;
begin
  new(aux);
  aux^.dato := enc;
  aux^.sig := l;
  l:= aux;
end;


{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista con datos de las encomiendas }
procedure crearLista(var l: Lista);
var
  e: encomienda;
  i: integer;
begin
 l:= nil;
 for i:= 1 to 20 do begin
   e.codigo := i;
   e.peso:= random (10);
   while (e.peso = 0) do e.peso:= random (10);
   agregarAdelante(L, e);
 End;
end;


{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista(l: Lista);
begin
 While (l <> nil) do begin
   writeln('Codigo: ', l^.dato.codigo, '  Peso: ', l^.dato.peso);
   l:= l^.sig;
 End;
end;

{actividad}
procedure AgregarCodigo (var l: listaCodigos; cod: integer);
var
 aux:listaCodigos;
begin
 new(aux);
 aux^.dato := cod;
 aux^.sig := l;
 l:= aux;
end;

procedure Insertar(registro:encomienda; var a:arbol);
begin
  if (a=nil) then begin
     new(a);
     a^.elem:=registro.peso;
     a^.codigos:=nil;
     AgregarCodigo(a^.codigos, registro.codigo);
     a^.HI:=nil;
     a^.HD:=nil;
  end
  else
    if (a^.elem>registro.peso) then
       Insertar(registro,a^.HI)
    else
      if (a^.elem<registro.peso) then
       Insertar(registro,a^.HD)
      else
        AgregarCodigo(a^.codigos, registro.codigo)
end;

procedure recorrer(l:lista; var a:arbol);
begin
 if(l<>nil)then begin
    Insertar(l^.dato,a);
    recorrer(l^.sig,a);
 end;
end;

procedure imprimir(l:listaCodigos);
begin
 if (l<>nil) then begin
  write(l^.dato, ' - ');
  imprimir(l^.sig);
 end;
end;

Procedure enOrden( a: arbol );
begin
  if ( a <> nil ) then begin
  enOrden (a^.HI);
  write ('peso ', a^.elem, ': ');
  imprimir(a^.codigos);
  writeln;
  enOrden (a^.HD)
  end;
end;
Var

 l: lista;
 a:arbol;
begin
 Randomize;

 crearLista(l);
 writeln ('Lista de encomiendas generada: ');
 imprimirLista(l);
 a:=nil;
 recorrer(l,a);
 enOrden(a);
 readln;
end.
