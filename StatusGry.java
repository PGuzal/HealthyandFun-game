
package gra;

/**
 * Klasa odpowiedzialna za wyznaczenie złych i dobrych odpowiedzi oraz reset danych
 * @author Patrycja Guzal
 */
public class StatusGry { 
   
    /**
     * Metoda odpowiedzialna za wpisywanie tekstu który ma się ukazać po zakończeniu poziomu do listy stringów
     */
    protected void wypiszWynik(){
        //Jeżeli wszystkie odpowiedzi na danym poziomie były dobre
        if((Dane.punktyDobre.size()==4&&Dane.nrPoziomu==2)||(Dane.punktyDobre.size()==12&&Dane.nrPoziomu==1)){
            //Jeżeli poziom drugi
            if(Dane.nrPoziomu==2){
                for(int k=0; k<Dane.punktyDobre.size();k++){
                    //Jeżeli wśród położonych obrazków były warzywa i if jest wykonywany pierwszy raz
                    if(Dane.korekta==false&&(((Dane.punktyDobre.get(k)==0||Dane.punktyDobre.get(k)==1||Dane.punktyDobre.get(k)==2||Dane.punktyDobre.get(k)==3)&&Dane.punktyDobre.get(k)==4)||Dane.punktyDobre.get(k)==4||Dane.punktyDobre.get(k)==0||Dane.punktyDobre.get(k)==1||Dane.punktyDobre.get(k)==2||Dane.punktyDobre.get(k)==3)){
                        for(int j=0; j<Dane.punktyDobre.size();j++){
                            //Jeżeli wśród położonych obrazków były mięsa i if jest wykonywany pierwszy raz
                            if(Dane.korekta==false&&(Dane.punktyDobre.get(j)==5||Dane.punktyDobre.get(j)==6||Dane.punktyDobre.get(j)==7||Dane.punktyDobre.get(j)==8||Dane.punktyDobre.get(j)==9||Dane.punktyDobre.get(j)==17)){
                                //Jeżeli wśród położonych obrazków były dodatki(makaron,ryż itp) i if jest wykonywany pierwszy raz
                                for(int c=0; c<Dane.punktyDobre.size();c++){
                                    //Jeżeli wśród położonych obrazków były dodatki(makaron,ryż itp) i if jest wykonywany pierwszy raz
                                    if(Dane.korekta==false&&(Dane.punktyDobre.get(c)==19||Dane.punktyDobre.get(c)==18||Dane.punktyDobre.get(c)==4||((Dane.punktyDobre.get(c)==19||Dane.punktyDobre.get(c)==18)&&Dane.punktyDobre.get(c)==4))){
                                        Dane.wyniki.add("Skomponowałeś zbilansowany posiłek");//dodanie wybranego tekstu do pola tekstowego
                                        Dane.zbilansowany=true;//oznaczenie, że posiłek był zbilansowany
                                        Dane.korekta=true;//blokowanie ponownego przejścia pętl
                                    }
                                }
                            }
                        }
                    }
                }
                Dane.wyniki.add("\nGratulacje!!!!\nOtrzymujesz Order zdrowego odżywiania\n");
            }
            //Jeżeli nie było oznaczonego, że posiłek jest zbilansowany
            if(Dane.zbilansowany!=true){
                Dane.wyniki.add("Nie skomponowałeś zbilansowanego posiłku jednak wybrałeś tylko zdrowe produkty");
            }
        }
        //Jeżeli nie wszystkie odpowiedzi na danym poziomie były dobre
        else{
            //Jeżeli były dobre odpowiedzi
            if(!Dane.punktyDobre.isEmpty()&&Dane.nrPoziomu==2){
                Dane.wyniki.add("\nDobre odpowiedzi");
                for(int k=0; k<Dane.punktyDobre.size();k++){    
                        switch(Dane.punktyDobre.get(k)){
                            case 0:{ Dane.wyniki.add("Sałata  ");
                            break;}
                            case 1:{ Dane.wyniki.add("Sałatka  ");
                            break;}
                            case 2:{ Dane.wyniki.add("Marchew  ");
                            break;}
                            case 3:{ Dane.wyniki.add("Pomidory  ");
                            break;}
                            case 4:{ Dane.wyniki.add("Ziemniak  ");
                            break;}
                            case 5:{ Dane.wyniki.add("Ryba  ");
                            break;}
                            case 6:{ Dane.wyniki.add("Boczek  ");
                            break;}
                            case 7:{ Dane.wyniki.add("Stek  ");
                            break;}
                            case 8:{ Dane.wyniki.add("Udko  ");
                            break;}
                            case 9:{ Dane.wyniki.add("Kiełbasa  ");
                            break;}
                            case 15:{ Dane.wyniki.add("Sok  ");
                            break;}
                            case 16:{ Dane.wyniki.add("Woda  ");
                            break;}
                            case 17:{ Dane.wyniki.add("Jajko  ");
                            break;}
                            case 18:{ Dane.wyniki.add("Ryż  ");
                            break;}
                            case 19:{ Dane.wyniki.add("Makaron  ");                             
                            break;} 
                        
                    }
                }
            } 
            //Jeżeli są złe odpowiedzi
            if(!Dane.punktyZle.isEmpty()){
                Dane.wyniki.add("\nZłe odpowiedzi");
                if(Dane.nrPoziomu==1){
                    for(int l=0; l<Dane.punktyZle.size();l++){
                        switch(Dane.punktyZle.get(l)){
                            case 0:{ Dane.wyniki.add("Jabłko  ");
                            break;}
                            case 1:{ Dane.wyniki.add("Gruszka  ");
                            break;}
                            case 2:{ Dane.wyniki.add("Kabaczek  ");
                            break;}
                            case 3:{ Dane.wyniki.add("Papryka  ");
                            break;}
                            case 4:{ Dane.wyniki.add("Boczek  ");
                            break;}
                            case 5:{ Dane.wyniki.add("Kiełbasa  ");
                            break;}
                            case 6:{ Dane.wyniki.add("Chleb  ");
                            break;}
                            case 7:{ Dane.wyniki.add("Ryż  ");
                            break;}
                            case 8:{ Dane.wyniki.add("Mleko  ");
                            break;}
                            case 9:{ Dane.wyniki.add("Ser żółty  ");
                            break;}
                            case 10:{ Dane.wyniki.add("Ser żółty  ");
                            break;}
                            case 11:{Dane.wyniki.add("Hot Dog  ");
                            break;}
                            case 12:{Dane.wyniki.add("Hamburger  ");
                            break;}
                            case 13:{Dane.wyniki.add("Frytki  ");
                            break;}
                            case 14:{ Dane.wyniki.add("Oliwa  ");
                            break;}
                        }
                    }
                }
                else{   
                    for(int l=0; l<Dane.punktyZle.size();l++){
                        switch(Dane.punktyZle.get(l)){
                            case 10:{Dane.wyniki.add("Pizza  ");
                                break;}
                            case 11:{Dane.wyniki.add("Hamburger  ");
                                break;}
                            case 12:{Dane.wyniki.add("Hot Dog  ");
                                break;}
                            case 13:{Dane.wyniki.add("Frytki  ");
                                break;}
                            case 14:{Dane.wyniki.add("Coca Cola  ");
                                break;}
                        }
                    }      
                }
            //Jeżeli na piramidzie są wszystkie rzeczy zdrowe ale nie we właściwych miejscach
            if(Dane.wyniki.size()!=13&&Dane.nrPoziomu==1){
                Dane.wyniki.add("\nPozostałe rzeczy właściwie trafiły na piramidę, jednak nie znalazły się na odpowiednich poziomach");
            }
            Dane.wyniki.add("\n\nNiestety!!!\nMusisz jednak poczytać jeszcze trochę o zdrowym odżywianiu");
            }
        }
        
    }//koniec metody wypiszWynik()
    /**
     * Metoda odpowiedzialną za zerowanie zmiennych, czyszczenie tablic i list
     */
    protected void reset(){
        Dane.blokada=0;
        Dane.nrPoziomu=0;
        Dane.zbilansowany=false;
        Dane.korekta=false;
        Dane.punktyDobre.clear();
        Dane.punktyZle.clear();
        Dane.wyniki.clear();
        Dane.tekstWyn = "";
        for(int k=0; k<Dane.kwadraty.length;k++){
            Dane.kwadraty[k]=0;
        }
        for(int k=0; k<Dane.wolny.length;k++){
             Dane.wolny[k]=true;
        }   
    }//koniec metody reset()
}//koniec klasy StatusGry

    


