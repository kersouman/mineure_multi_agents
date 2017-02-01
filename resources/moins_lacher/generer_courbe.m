clear all
close all

%% Lecture des fichiers de philosophes
p0 = csvread('philosophe_0.csv',1,0);
p1 = csvread('philosophe_1.csv',1,0);
p2 = csvread('philosophe_2.csv',1,0);
p3 = csvread('philosophe_3.csv',1,0);
p4 = csvread('philosophe_4.csv',1,0);

%% Calcul des valeurs moyennes
moyenne = (p0 + p1 + p2 + p3 + p4)/5;
moyenne = [p0(:,1) moyenne(:,2:4)];

%% Affichage des taux
figure('Name', 'Message et moins lacher')
    plotyy(moyenne(:,1), moyenne(:,3:4),moyenne(:,1), moyenne(:,2))
    legend('Faim','Pensées','Famine')
    grid on