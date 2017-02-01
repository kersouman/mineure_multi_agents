clear all
close all

%% Generation de la structure contenant les donn�es
generer_data

%% Calcul des valeurs moyennes
fields = fieldnames(data);

moyenne = zeros(20000,4);
moyenne(:,1) = 0:19999;
taux_faim = 0;

for i=1:numel(fields)
    moyenne(:,2:4) = 0.2*(data.(fields{i}).p0(:,2:4)...
                        + data.(fields{i}).p1(:,2:4)...
                        + data.(fields{i}).p2(:,2:4)...
                        + data.(fields{i}).p3(:,2:4)...
                        + data.(fields{i}).p4(:,2:4));
    data.(fields{i}).moyenne = moyenne(:,[1,3,4]);
    for k=1:length(moyenne)
        taux_faim = taux_faim + moyenne(k,2);
    end
    taux_faim = taux_faim/length(moyenne);
    data.(fields{i}).taux_faim = taux_faim;
end

clear fields i k moyenne taux_faim

%% Comparaison avec et sans messages
figure('Name', 'Sans et avec messages')
    data_to_plot = [data.no_messages.moyenne(:,2),...
                    data.messages.moyenne(:,2),...
                    data.no_messages.moyenne(:,3),...
                    data.messages.moyenne(:,3)];
    plot(data.messages.moyenne(:,1),data_to_plot)
    legend('Taux moyen de pens�es sans messages',...
           'Taux moyen de pens�es avec messages',...
           'Taux moyen de famine sans messages',...
           'Taux moyen de famine avec messages')
    xlabel('Nombre de tours')
    grid on

%% Comparaison en variant seuil rassasie
figure('Name', 'Variation seuil rassasie')
    data_to_plot = [data.messages.moyenne(:,2),...
                    data.plus_rassasie.moyenne(:,2),...
                    data.messages.moyenne(:,3),...
                    data.plus_rassasie.moyenne(:,3)];
    plot(data.messages.moyenne(:,1),data_to_plot)
    legend('Taux moyen de pens�es nominal',...
           'Taux moyen de pens�es en augmentant seuil rassasie',...
           'Taux moyen de famine nominal',...
           'Taux moyen de famine en augmentant seuil rassasie')
    xlabel('Nombre de tours')
    grid on    

%% Comparaison var_penser
figure('Name', 'Variation de var penser')
    data_to_plot = [data.messages.moyenne(:,2),...
                    data.moins_var_penser.moyenne(:,2),...
                    data.plus_var_penser.moyenne(:,2),...
                    data.messages.moyenne(:,3),...
                    data.moins_var_penser.moyenne(:,3),...
                    data.plus_var_penser.moyenne(:,3)];
    plot(data.messages.moyenne(:,1),data_to_plot)
    legend('Taux moyen de pens�es nominal',...
           'Taux moyen de pens�es en diminuant var penser',...
           'Taux moyen de pens�es en augmentant var penser',...
           'Taux moyen de famine nominal',...
           'Taux moyen de famine en diminuant var penser',...
           'Taux moyen de famine en augmentant var penser')
    xlabel('Nombre de tours')
    grid on
    
%% Comparaison var_manger
figure('Name', 'Variation de var manger')
    data_to_plot = [data.messages.moyenne(:,2),...
                    data.moins_var_manger.moyenne(:,2),...
                    data.plus_var_manger.moyenne(:,2),...
                    data.messages.moyenne(:,3),...
                    data.moins_var_manger.moyenne(:,3),...
                    data.plus_var_manger.moyenne(:,3)];
    plot(data.messages.moyenne(:,1),data_to_plot)
    legend('Taux moyen de pens�es nominal',...
           'Taux moyen de pens�es en diminuant var manger',...
           'Taux moyen de pens�es en augmentant var manger',...
           'Taux moyen de famine nominal',...
           'Taux moyen de famine en diminuant var manger',...
           'Taux moyen de famine en augmentant var manger')
    xlabel('Nombre de tours')
    grid on
    
%% Comparaison seuil_lacher
figure('Name', 'Variation de seuil lacher')
    data_to_plot = [data.messages.moyenne(:,2),...
                    data.moins_lacher.moyenne(:,2),...
                    data.plus_lacher.moyenne(:,2),...
                    data.messages.moyenne(:,3),...
                    data.moins_lacher.moyenne(:,3),...
                    data.plus_lacher.moyenne(:,3)];
    plot(data.messages.moyenne(:,1),data_to_plot)
    legend('Taux moyen de pens�es nominal',...
           'Taux moyen de pens�es en diminuant seuil lacher',...
           'Taux moyen de pens�es en augmentant seuil lacher',...
           'Taux moyen de famine nominal',...
           'Taux moyen de famine en diminuant seuil lacher',...
           'Taux moyen de famine en augmentant seuil lacher')
    xlabel('Nombre de tours')
    grid on

clear data_to_plot