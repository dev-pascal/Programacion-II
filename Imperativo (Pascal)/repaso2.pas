Program repaso2;
Uses
    sysutils;
Type
    fechaYHora = record
        dia: 1..31;
        mes: 1..12;
        anio: integer;
        hora: 0..23;
        min: 0..59;
    end;

    compra = record
        dni: longint; //es un entero que permite 8 cifras (sin puntos)
        codProducto: integer;
        fechaHora: fechaYHora;
        monto: real;
    end;

    listaCompras = ^nodoLista;
    nodoLista = record
        dato: compra;
        sig: listaCompras;
    end;

{estructura de datos del ejercicio}

    listaDNI = ^nodoDNI;
    nodoDNI = record
        dato: integer;
        sig: listaDNI;
    end;

    producto = record
        codigo: integer;
        monto: real;
        lista: listaDNI;
    end;

    arbol = ^nodoArbol;
    nodoArbol = record
        dato: producto;
    	hi, hd: arbol;
    end;

{procesos}

procedure agregarDNI (DNI:integer ; var l:listaDNI; n:real; var monto:real);
var aux:listaDNI;
begin
  new(aux);
  aux^.dato:=DNI;
  aux^.sig:=l;
  l:=aux;
  monto:=monto+n;
end;

procedure agregarElemento(registro:compra; var a:arbol);
begin
 if (a=nil) then begin
    new(a);
    a^.hd:=nil;
    a^.hi:=nil;
    a^.dato.codigo:=registro.codProducto;
    a^.dato.monto:=0;
    a^.dato.lista:=nil;
    agregarDNI(registro.DNI ,a^.dato.lista, registro.monto, a^.dato.monto );
 end
 else begin
   if (registro.codProducto < a^.dato.codigo) then
     agregarElemento(registro, a^.hi)
   else
       if (registro.codProducto>a^.dato.codigo) then
         agregarElemento(registro, a^.hd)
       else
         agregarDNI(registro.DNI ,a^.dato.lista,registro.monto , a^.dato.monto)
 end;
end;

procedure VerValoresEnRango ( a:arbol; inf:integer; sup:integer);
begin
 if (a<>nil) then
   if (a^.dato.codigo>=inf) then
     if (a^.dato.codigo<=sup) then begin
       writeln;
       write(a^.dato.codigo,'   monto: ');
       writeln(a^.dato.monto:2:2);
       VerValoresEnRango(a^.HI,inf,sup);
       VerValoresEnRango(a^.HD,inf,sup);
     end
     else
       VerValoresEnRango(a^.HI,inf,sup)
     else
       VerValoresEnRango(a^.HD,inf,sup)
   end;

procedure recorroLista(l:listaCompras; var cant:integer);
begin
 if (l<>nil) then begin
    if (l^.dato.monto>500) then
      cant:=cant+1;
    recorroLista(l^.sig, cant);
 end;
end;

procedure AgregarArbol (L:listaCompras; var a:arbol);
begin
   if (L<>nil) then begin
      agregarElemento(l^.dato,a);
      AgregarArbol(L^.sig,a);
   end;
end;

{-----------------------------------------------------------------------------
CARGARFECHA - Genera una FECHA Y HORA aleatorias }
procedure cargarFecha(var f: fechaYHora);
begin
    with f do begin
        dia := random(30)+1;
        mes := random(12)+1;
        if(mes = 2)then
            dia:= (dia mod 29)+1
        else
            if(mes = 4)or(mes = 6)or(mes = 9)or(mes = 11)then
                dia:= (dia mod 31)+1;
        anio := ((random(20)+1)*2018) mod 2020;
        hora := random(24);
        min := random(60);
    end;
end;

{-----------------------------------------------------------------------------
AGREGARADELANTE - Agrega adelante}
Procedure agregarAdelante(var l: listaCompras; c: compra);
var
    nue:listaCompras;
begin
    new(nue);
    nue^.dato:=c;
    nue^.sig:=l;
    l:=nue;
end;

{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista con compras aleatorias }
procedure crearLista(var l: listaCompras);
var
    i: integer;
    c: compra;
begin
    for i:=1 to random(20)+5 do begin
        c.dni := random(46000000)+10000000;
        c.codProducto := random (32000);
        c.monto := Random * random(4000);
        cargarFecha(c.fechaHora);
        agregarAdelante(l, c);
    end;
end;

{-----------------------------------------------------------------------------
IMPRIMIRELEMENTO - Muestra en pantalla una fechaHora }
procedure imprimirFechaHora(f: fechaYHora);
begin
    with(f) do begin
        if(dia < 10)then //imprime el cero anterior
            write('0');
        write(dia,'/');
		if(mes < 10)then //imprime el cero anterior
            write('0');
		write(mes,'/', anio,' a las ');
        if(hora < 10)then //imprime el cero anterior
            write('0');
        write(hora, ':');
        if(min < 10)then //imprime el cero anterior
            write('0');
        write(min, 'hs.');
    end;
end;

{-----------------------------------------------------------------------------
IMPRIMIRELEMENTO - Muestra en pantalla una compra }
procedure imprimir(c: compra);
begin
    with(c) do begin
        write('Compra realizada el ');
        imprimirFechaHora(fechaHora);
        write(' del cliente con dni ', dni, ' por el monto de $', monto:1:2, ' y el producto ', codProducto);
        writeln();
    end;
end;

{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista(l: listaCompras);
begin
    while (l <> nil) do begin
        imprimir(l^.dato);
        l:= l^.sig;
    end;
end;

Var
    l: listaCompras;
    a:arbol;
    cant:integer;

begin
    Randomize;

    l:= nil;
    crearLista(l);

    writeln ('Lista disponible: ');
    imprimirLista(l);
    cant:=0;
    {Completar el programa}
    AgregarArbol(l,a); {inciso a}
    recorroLista(l,cant); {inciso b}
    writeln('cantidad de compras que excede 500$:',cant); {inciso b}
    VerValoresEnRango(a, 2000, 7000); {inciso c}
    writeln('Fin del programa');
    readln;
end.
