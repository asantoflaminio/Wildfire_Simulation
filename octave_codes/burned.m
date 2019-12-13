input1 = dlmread('BurnedCells4.txt', '');
input1([1,2],:) = [];
x = input1(:,1);
y = input1(:,2); %fraccion de particulas
plot(x,y, "marker", 'o',"linestyle", "-", "color", "m", "linewidth", 1);
hold on;
xo = x(end/2 + 1/2); %valor del medio


ending = x(end);
t = x;
finalvalue = y(end);
k = (0.01:0.0001:1.0);

for i=1:length(k)
  for j = 1:length(t)
     f(i,j) = finalvalue/ (1 + exp(-k(i)*(t(j)-xo))); 
  endfor
endfor

error = 0; 
% for externo, me va a agarrar la fila del 'm' correspondiente en 'y'
for i = 1:length(k)
  c = f(i,:);
  %ahora voy a recorrer y tomar los valores de 'd'
  for j = 1:length(t)
   error += (y(j) - c(j))^2;
   error
  endfor
  e(i,1) = error;
  error = 0;
endfor


for i = 1:length(k)
  index = find(e == min(e));
  plot(x,f(index,:),'b-')
hold on
endfor

set (gca, "xgrid", "on");
set (gca, "ygrid", "on");
xlabel ("Tiempo [s]", "fontsize", 20);
ylabel("Celdas quemadas", "fontsize", 20);
set(gca, 'FontSize', 20)
hold on; 