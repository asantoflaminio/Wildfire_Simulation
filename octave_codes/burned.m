input1 = dlmread('BurnedCells_0.4_2.txt', '');
input1([1,2],:) = [];
x = input1(:,1);
y = input1(:,2); %fraccion de particulas
%plot(x,y, "marker", 'o',"linestyle", "-", "color", "m", "linewidth", 1);
%hold on;
if(mod(length(x),2) ==0)
  num = 1;
else
  num = 1.5;
endif

xo = x(end/2 + num); %valor del medio

ending = x(end);
t = x;
finalindex = find(y == max(y));
finalvalue = y(finalindex);
k = (0.15:0.0001:0.25);

for i=1:length(k)
  for j = 1:length(t) 
     f(i,j) = finalvalue/ (1 + exp(-k(i)*(t(j)-xo))); 
  endfor
endfor


for i=1:length(k)
  subst = f(i,1);
  for j = 1:length(t) 
     f(i,j) = f(i,j) - subst; 
  endfor
endfor

error = 0; 
for i = 1:length(k)
  c = f(i,:);
  for j = 1:length(t)
   error += (c(j) - y(j))^2;
   %error
  endfor
  e(i) = error/length(t);
  error = 0;
endfor

  index = find(e == min(e));
%for i = 1:length(k)
 % index = find(e == min(e));
 % plot(x,f(index,:),'b-')
%hold on
%endfor
valorK = k(index)
errorTotal = min(e)

%set (gca, "xgrid", "on");
%set (gca, "ygrid", "on");
%xlabel ("Tiempo [s]", "fontsize", 20);
%ylabel("Celdas quemadas", "fontsize", 20);
%set(gca, 'FontSize', 20)
%hold on; 