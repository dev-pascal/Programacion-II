Program twitter_2;
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

     {Completar agregando aquí las estructuras de datos necesarias en el ejercicio}
     datoM=record
               mensaje:string;
               esRetweet: boolean;
     end;

          listaMensajes= ^nodoMensajes;
          nodoMensajes=record
                    dato:datoM;
                    sig:listaMensajes;
          end;
     datoU=record
               codigoUsuario: integer;
               nombreUsuario: string;
               mensajeL:listaMensajes;
     end;


     listaUsuarios=^nodoUsuarios;
     nodoUsuarios=record
               dato:datoU;
               sig:listaUsuarios;
     end;

{agregarAdelante - Agrega nro adelante de l}
Procedure agregarAdelante(var l: listaTweets; t: tweet);
var
   aux: listaTweets;
begin
     new(aux);
     aux^.dato := t;
     aux^.sig := l;
     l:= aux;
end;



{crearLista - Genera una lista con tweets aleatorios}
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
     v[7]:='alejandro';
     v[8]:= 'silvana';
     v[9]:= 'federico';
     v[10]:= 'ruth';

     t.codigoUsuario := random(11);
     while (t.codigoUsuario <> 0) do Begin
          texto:= Concat(v[t.codigoUsuario], '-mensaje-', IntToStr(random (200)));
          t.nombreUsuario := v[t.codigoUsuario];
          t.mensaje := texto;
          t.esRetweet := (random(2)=0);
          agregarAdelante(l, t);
          t.codigoUsuario := random(11);
     end;
end;


{imprimir - Muestra en pantalla el tweet}
procedure imprimir(t: tweet);
begin
     with (t) do begin
          write('Tweet del usuario @', nombreUsuario, ' con codigo ',codigoUsuario, ': ', mensaje, ' RT:');
          if(esRetweet)then
               writeln(' Si')
          else
               writeln('No ');
     end;
end;


{imprimirLista - Muestra en pantalla la lista l}
procedure imprimirLista(l: listaTweets);
begin
     while (l <> nil) do begin
          imprimir(l^.dato);
          l:= l^.sig;
     end;
end;


{agregarElemento - Resuelve la inserción de la estructura ordenada}
procedure agregarOrdenado(var pri:listaTweets; t:tweet);
var
   nuevo, anterior, actual: listaTweets;
begin
     new (nuevo);
     nuevo^.dato:= t;
     nuevo^.sig := nil;
     if (pri = nil) then
          pri := nuevo
     else
     begin
          actual := pri;
          anterior := pri;
          while (actual<>nil) and (actual^.dato.nombreUsuario < nuevo^.dato .nombreUsuario) do begin
               anterior := actual;
               actual:= actual^.sig;
          end;
          if (anterior = actual) then
               pri := nuevo
          else
               anterior^.sig := nuevo;
          nuevo^.sig := actual;
     end;
end;


{generarNuevaEstructura - Resuelve la generación estructura ordenada}
procedure generarNuevaEstructura (lT: listaTweets; VAR listaOrdenada: listaTweets);
begin
     listaOrdenada := nil;
     while(lT <> nil) do begin
          agregarOrdenado(listaOrdenada, lT^.dato);
          lT := lT^.sig;
     end;
end;

{NUEVO}

procedure cargarMensajes(var listaM:listaMensajes; r:tweet);
var
   aux,nue:listaMensajes;
begin
     new(nue);
     nue^.dato.mensaje:=r.mensaje;
     nue^.dato.esRetweet:=r.esRetweet;
     nue^.sig:=nil;
     if (listaM=nil) then begin
          listaM:=nue;
     end
     else begin
          aux:=listaM;
          while (aux<>nil) do
             aux:=aux^.sig;
          aux:=nue;
     end;
end;

procedure inicializar (var u:listaUsuarios; r:tweet);
var
   nue:listaUsuarios;
begin
     new(nue);
     nue^.dato.codigoUsuario:=r.codigoUsuario;
     nue^.dato.nombreUsuario:=r.nombreUsuario;
     nue^.dato.mensajeL:=nil;
     nue^.sig:=nil;
     if (u=nil) then begin
          u:=nue;
     end
     else begin
          u^.sig:=nue;
          u:=u^.sig;
     end;
end;

procedure cargarLista (var l:listaUsuarios; lo:listaTweets);
var
   actU:integer;
   ult:listaUsuarios;
begin
   ult:=l;
   while (lo<>nil) do begin
        inicializar(ult,lo^.dato);
        actU:=lo^.dato.codigoUsuario;
        while (actU=lo^.dato.codigoUsuario) do begin
             cargarMensajes(ult^.dato.MensajeL, lo^.dato);
             lo:=lo^.sig;
        end;
   end;
end;

var
   l, l_ordenada: listaTweets;
   ln:listaUsuarios;
begin
     Randomize;

     l:= nil;
     crearLista(l);
     writeln ('Lista generada: ');
     imprimirLista(l);

     {Se crea la estructura ordenada}
     l_ordenada:= nil;
     generarNuevaEstructura(l,l_ordenada);
     writeln ('Lista ordenada: ');
     imprimirLista(l_ordenada);

     {Completar el programa}
     ln:=nil;
     cargarLista(ln,l_ordenada);
     writeln('Fin del programa');
     readln;
end.
