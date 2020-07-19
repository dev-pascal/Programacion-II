Program clase5parte2;
Uses
	sysutils;
Type
	tweet = record
		codigoUsuario: integer;
		nombreUsuario: string;
		mensaje: string;
		esRetweet: boolean;
	end;

	listaTweets = ^nodoLista;
	nodoLista = record
		dato: tweet;
		sig: listaTweets;
	end;

	{Completar agregando aqu� las estructuras de datos necesarias en el ejercicio 1}

        listaMensajes = ^nodoMensaje;
        nodoMensaje = record
	   dato: string;
	   sig: listaMensajes;
        end;

        usuario = record
	   codigoUsuario: integer;
	   nombreUsuario: string;
	   mensajes: listaMensajes;
        end;

        arbol = ^nodoArbol;
        nodoArbol = record
	   dato: usuario;
	   hi, hd: arbol;
        end;



{-----------------------------------------------------------------------------
AgregarAdelante - Agrega nro adelante de l}

Procedure agregarAdelante(var l: listaTweets; t: tweet);
var
  aux: listaTweets;
begin
  new(aux);
  aux^.dato := t;
  aux^.sig := l;
  l:= aux;
end;



{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista con tweets aleatorios }
procedure crearLista(var l: listaTweets);
var
  t: tweet;
  texto: string;
  v : array [1..10] of string;

begin

 v[1]:= 'juan';
 v[2]:= 'pedro';
 v[3]:= 'carlos';
 v[4]:= 'julia';
 v[5]:= 'mariana';
 v[6]:= 'gonzalo';
 v[7]:='alejandra';
 v[8]:= 'silvana';
 v[9]:= 'angie';
 v[10]:= 'hernan';

 l:= nil;
 t.codigoUsuario := random (1000);
 while (t.codigoUsuario <> 0) do Begin
   texto:= Concat(v[(t.codigoUsuario mod 10)], '-mensaje-', IntToStr(random (100)));
   t.nombreUsuario := v[(t.codigoUsuario mod 10)];
   t.mensaje := texto;
   t.esRetweet := (random (1) = 0);
   agregarAdelante(l, t);
   t.codigoUsuario := random (1000);
 End;
end;


{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista(l: listaTweets);
begin
 While (l <> nil) do begin
   writeln('---');
   writeln('usuario: ',l^.dato.nombreUsuario,'  ', l^.dato.codigoUsuario);
   writeln('mensaje: ',l^.dato.mensaje);
   writeln('---');
   l:= l^.sig;
 End;
end;

{-----------------------------------------------------------------------------
AGREGARELEMENTO - Resuelve la inserci�n de la estructura de la ACTIVIDAD 1
agregarElemento ( VAR arbolUsuarios, elementoLista)
 Completar
}
procedure agregarMensaje (m:string ; var listaM:listaMensajes);
var aux:listaMensajes;
begin
  new(aux);
  aux^.dato:=m;
  aux^.sig:=listaM;
  listaM:=aux;
end;

procedure agregarElemento(registro:tweet; var a:arbol);
begin
 if (a=nil) then begin
    new(a);
    a^.hd:=nil;
    a^.hi:=nil;
    a^.dato.codigoUsuario:=registro.codigoUsuario;
    a^.dato.nombreUsuario:=registro.nombreUsuario;
    a^.dato.mensajes:=nil;
    agregarMensaje(registro.mensaje ,a^.dato.mensajes);
 end
 else begin
   if (registro.codigoUsuario < a^.dato.codigoUsuario) then
     agregarElemento(registro, a^.hi)
   else
       if (registro.codigoUsuario>a^.dato.codigoUsuario) then
         agregarElemento(registro, a^.hd)
       else
         agregarMensaje(registro.mensaje ,a^.dato.mensajes)
 end;
end;

{-----------------------------------------------------------------------------
GENERARNUEVAESTRUCTURA - Resuelve la generaci�n de la ACTIVIDAD 1
generarNuevaEstructura (listaTweets, VAR arbolUsuarios)
	mientras (no llegue al final de la lista de tweets)
		agregarElemento (arbolUsuarios, elementoLista);
		avanzar en el recorrido de la lista
}
procedure GenerarNuevasEstructuras (listaT: listaTweets; var a:arbol);
begin
 if (listaT<>nil) then begin
    agregarElemento(listaT^.dato, a);
    GenerarNuevasEstructuras(listaT^.sig, a);
 end;
end;

{-----------------------------------------------------------------------------
CANTIDADTWEETS - Resuelve la cuenta de elementos de la ACTIVIDAD 2
cantidadTweets (usuario)
	// recorrer la lista de tweets
}

{-----------------------------------------------------------------------------
RECORRERARBOL - Resuelve el recorrido de la ACTIVIDAD 2
recorrerArbol (arbolUsuarios)
	si (tenemos un nodo en la ra�z)
		si (el c�digo de usuario > 200)
			si (el c�digo de usuario < 700)
				informar (cantidadTweets (usuarioActual));
				recorrerArbol (hijoIzquierdo)
				recorrerArbol (hijoDerecho)
			sino
				recorrerArbol (hijoIzquierdo)
		sino
			recorrerArbol (hijoDerecho)
}

procedure imprimir(l:listaMensajes);
begin
 if (l<>nil) then begin
  writeln(l^.dato, ' . ');
  imprimir(l^.sig);
 end;
end;

Procedure enOrden( a: arbol );
begin
  if ( a <> nil ) then begin
  enOrden (a^.HI);
  writeln (a^.dato.codigoUsuario, ':');
  imprimir(a^.dato.mensajes);
  enOrden (a^.HD)
  end;
end;

Var

 l: listaTweets;
 {Completar agregando variables}
 a:arbol;
begin
 Randomize;
 a:=nil;
 crearLista(l);
 writeln ('Lista generada: ');
 imprimirLista(l);

 {Completar el programa}
 GenerarNuevasEstructuras(l,a);
 enOrden(a);
 writeln('Fin del programa');
 readln;
end.
