%% Lecture des fichiers de philosophes dans messages
p0 = csvread('messages/philosophe_0.csv',1,0);
p1 = csvread('messages/philosophe_1.csv',1,0);
p2 = csvread('messages/philosophe_2.csv',1,0);
p3 = csvread('messages/philosophe_3.csv',1,0);
p4 = csvread('messages/philosophe_4.csv',1,0);
messages = struct('p0', p0, 'p1', p1, 'p2', p2, 'p3', p3, 'p4', p4);

%% Lecture des fichers de philosophes dans moins_lacher
p0 = csvread('moins_lacher/philosophe_0.csv',1,0);
p1 = csvread('moins_lacher/philosophe_1.csv',1,0);
p2 = csvread('moins_lacher/philosophe_2.csv',1,0);
p3 = csvread('moins_lacher/philosophe_3.csv',1,0);
p4 = csvread('moins_lacher/philosophe_4.csv',1,0);
moins_lacher = struct('p0', p0, 'p1', p1, 'p2', p2, 'p3', p3, 'p4', p4);

%% Lecture des fichers de philosophes dans moins_var_manger
p0 = csvread('moins_var_manger/philosophe_0.csv',1,0);
p1 = csvread('moins_var_manger/philosophe_1.csv',1,0);
p2 = csvread('moins_var_manger/philosophe_2.csv',1,0);
p3 = csvread('moins_var_manger/philosophe_3.csv',1,0);
p4 = csvread('moins_var_manger/philosophe_4.csv',1,0);
moins_var_manger = struct('p0', p0, 'p1', p1, 'p2', p2, 'p3', p3, 'p4', p4);

%% Lecture des fichers de philosophes dans moins_var_penser
p0 = csvread('moins_var_penser/philosophe_0.csv',1,0);
p1 = csvread('moins_var_penser/philosophe_1.csv',1,0);
p2 = csvread('moins_var_penser/philosophe_2.csv',1,0);
p3 = csvread('moins_var_penser/philosophe_3.csv',1,0);
p4 = csvread('moins_var_penser/philosophe_4.csv',1,0);
moins_var_penser = struct('p0', p0, 'p1', p1, 'p2', p2, 'p3', p3, 'p4', p4);

%% Lecture des fichers de philosophes dans no_messages
p0 = csvread('no_messages/philosophe_0.csv',1,0);
p1 = csvread('no_messages/philosophe_1.csv',1,0);
p2 = csvread('no_messages/philosophe_2.csv',1,0);
p3 = csvread('no_messages/philosophe_3.csv',1,0);
p4 = csvread('no_messages/philosophe_4.csv',1,0);
no_messages = struct('p0', p0, 'p1', p1, 'p2', p2, 'p3', p3, 'p4', p4);

%% Lecture des fichers de philosophes dans plus_lacher
p0 = csvread('plus_lacher/philosophe_0.csv',1,0);
p1 = csvread('plus_lacher/philosophe_1.csv',1,0);
p2 = csvread('plus_lacher/philosophe_2.csv',1,0);
p3 = csvread('plus_lacher/philosophe_3.csv',1,0);
p4 = csvread('plus_lacher/philosophe_4.csv',1,0);
plus_lacher = struct('p0', p0, 'p1', p1, 'p2', p2, 'p3', p3, 'p4', p4);

%% Lecture des fichers de philosophes dans plus_rassasie
p0 = csvread('plus_rassasie/philosophe_0.csv',1,0);
p1 = csvread('plus_rassasie/philosophe_1.csv',1,0);
p2 = csvread('plus_rassasie/philosophe_2.csv',1,0);
p3 = csvread('plus_rassasie/philosophe_3.csv',1,0);
p4 = csvread('plus_rassasie/philosophe_4.csv',1,0);
plus_rassasie = struct('p0', p0, 'p1', p1, 'p2', p2, 'p3', p3, 'p4', p4);

%% Lecture des fichers de philosophes dans plus_var_manger
p0 = csvread('plus_var_manger/philosophe_0.csv',1,0);
p1 = csvread('plus_var_manger/philosophe_1.csv',1,0);
p2 = csvread('plus_var_manger/philosophe_2.csv',1,0);
p3 = csvread('plus_var_manger/philosophe_3.csv',1,0);
p4 = csvread('plus_var_manger/philosophe_4.csv',1,0);
plus_var_manger = struct('p0', p0, 'p1', p1, 'p2', p2, 'p3', p3, 'p4', p4);

%% Lecture des fichers de philosophes dans plus_var_penser
p0 = csvread('plus_var_penser/philosophe_0.csv',1,0);
p1 = csvread('plus_var_penser/philosophe_1.csv',1,0);
p2 = csvread('plus_var_penser/philosophe_2.csv',1,0);
p3 = csvread('plus_var_penser/philosophe_3.csv',1,0);
p4 = csvread('plus_var_penser/philosophe_4.csv',1,0);
plus_var_penser = struct('p0', p0, 'p1', p1, 'p2', p2, 'p3', p3, 'p4', p4);

%% Génération de la structure générale
data = struct('messages', messages,...
              'moins_lacher', moins_lacher,...
              'moins_var_manger', moins_var_manger,...
              'moins_var_penser', moins_var_penser,...
              'no_messages', no_messages,...
              'plus_lacher', plus_lacher,...
              'plus_rassasie', plus_rassasie,...
              'plus_var_manger', plus_var_manger,...
              'plus_var_penser', plus_var_penser);

clear messages moins_lacher moins_var_manger...
      moins_var_penser no_messages plus_lacher...
      plus_rassasie plus_var_manger plus_var_penser
clear p0 p1 p2 p3 p4