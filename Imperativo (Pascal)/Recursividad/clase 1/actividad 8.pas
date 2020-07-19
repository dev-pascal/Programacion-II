program vectorordenado;

const
    dimF = 8;  {Dimensión física del vector}

type

    vector = array [1..dimF] of integer;

    dim = 0..dimF;

{-----------------------------------------------------------------------------
CARGARVECTORORDENADO - Carga ordenadamente nros aleatorios entre 0 y 100 en el
vector hasta que llegue el nro 99 o hasta que se complete el vector}

Procedure cargarVectorOrdenado ( var vec: vector; var dimL: dim);
var
   d, pos, j: integer;
begin
    Randomize;  { Inicializa la secuencia de random a partir de una semilla}
    dimL := 0;
    d:= random(100);
    while (d <> 99)  and ( dimL < dimF ) do begin
       pos:= 1;
       while (pos <= dimL) and (vec[pos]< d) do pos:= pos + 1;
       for  j:= dimL downto pos do vec[j+1]:= vec[j] ;
       vec[pos]:= d;
       dimL := dimL + 1;
       d:= random(100)
     end;
end;

{-----------------------------------------------------------------------------
IMPRIMIRVECTOR - Imprime todos los nros del vector }

Procedure imprimirVector ( var vec: vector; var dimL: dim );
var
   i: dim;
begin
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     write (' ');
     for i:= 1 to dimL do begin
        if(vec[i] < 9)then
            write ('0');
        write(vec[i], ' | ');
     end;
     writeln;
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     writeln;
End;
procedure Buscar (num: integer; dimL,inf,sup: dim; v:vector; var exito: boolean);
var mitad:dim;
begin
    if (dimL=0) then
        exito:=false
    else begin
         if (v[dimL]=num) then
            exito:=true
         else begin
            mitad:=(inf+sup)div 2;
            if (dimL<>mitad) then
               if (v[mitad]<num) then
                  Buscar(num,mitad,mitad,sup,v,exito)
               else
                   Buscar(num,mitad,inf,mitad,v,exito)
            else
               exito:=false
          end;
    end;
end;

{PROGRAMA PRINCIPAL}
var
   v: vector;
   dimL : dim;
   num: integer; exito:boolean;
begin

     cargarVectorOrdenado(v,dimL);

     writeln('Nros almacenados: ');
     imprimirVector(v, dimL);
     read(num);
     Buscar(num,dimL,1,dimL,v,exito);
     write(exito);
     readln(num);
end.
