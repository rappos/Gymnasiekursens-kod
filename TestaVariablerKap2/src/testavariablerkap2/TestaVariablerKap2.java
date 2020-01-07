package testavariablerkap2;

import java.util.Scanner;


/* Detta exempel tar upp det viktigaste i kapitel 2. Börja med att gå igenom 
    koden och  kommentarrerna nedan. Läs sedan kapitlet i boken med tilläggsmaterial
    från Onedrive. Läsanvisning finns längst ner i denna fil.
*/

public class TestaVariablerKap2 {

    public static void main(String[] args) {
        //Skapa variabler av de vanligaste typerna

        //Först två int, som är ett 32 bitars heltal.
        //int är standard för heltal i Java. Både större och mindre heltalstyper finns.
        //Möjliga värden för en int är från ca minus två miljarder till ca 2 miljarder.
        int antal; //Deklaration. Variabeln skapas
        int prisKr = 399; //Initiering. Variabeln skapas OCH får ett värde
        
        //Nu några double, som är på 64 bitar och klarar decimaltal
        //En double har plats för ca 15 värdesiffror med decimalpunkten på valfri plats
        //Max är ca 10 upphöjt till 308. double är standard för decimaltal i Java.
        double bredd = 3.55; //Initiering. Använd decimalpunkt i javakod.
        double distansTillSolen = 1.5e11; //Betyder 1.5 gånger tio upphöjt till 11.
        final double PI = 3.14159265; //Final gör att värdet inte kan ändras. 
        //Konstanter som pi stavas ofta med bara stora bokstäver.
        
        //Datatypen boolean kan bara innehålla sant eller falskt
        boolean skaSkrivaUt; //Om den är sann ska text skrivas ut av programmet
        
        //Två stycken char-variabler som kan innehålla varsitt tecken
        char tecken = 's'; //Initiering. Enstaka tecken skrivs med enkla ' inte med "
        char initial;
        
        //Till slut en sträng som kan innehålla en text.
        //Strängar är sammansatta (består av noll eller fler tecken)
        //och typen String stavas därför med stort S.
        String minText = "Hej hopp!";
       
        //För att kunna läsa in saker från tangentbordet skapar vi en Scanner som
        //får sitt eget variabelnamn som vi använder senare i koden.
        //Scannern är också en sammansatt typ så Scanner är med stort S.
        //Scannern skapas med nyckelordet new.
        Scanner input = new Scanner(System.in); //Kräver import, se överst i filen
        
        //Experimentera nu lite med variablerna
        
        //Först en utskrift
        System.out.print("Skriv ut en int: ");
        System.out.println(prisKr); //Testa vad som händer om vi försöker skriva ut
                                    //antal som inte fått något värde!
        //Nu läser vi in ett tal
        System.out.print("Ange antal: "); //Skriv ut ledtext
        antal = input.nextInt(); // Läs in ett heltal och lagra i variabeln antal
        //Det vi just gjorde var en tilldelning som gav antal ett nytt värde.
        
        //Nu kan vi använda antal i en utskrift
        //Vi låter antal ingå i en enkel formel. Först beräknas antal*2 eftersom
        //det står inom parentes. Sedan läggs det ihop med texten med +.
        System.out.println("Dubbla antalet är " + (antal*2));

        //Vi testar att läsa in en double
        System.out.print("Ange kvadratens bredd i cm (använd kommatecken , för decimaltal): ");
        bredd = input.nextDouble(); //Scannern anpassar sig till svensk standard med ,-tecken
        System.out.println("Arean blir då " + (bredd*bredd) + " kvadratcentimeter." );
        //På raden ovan beräknas bredd*bredd och omvandlas sedan automatiskt till text
        
        //Några tilldelningar
        bredd = 5; //Går bra trots att 5 är en int och bredd är en double.
        //Int kan alltså automatiskt omvandlas till double vid behov

        //antal = bredd; //Ger kompileringsfel. Double omvandlas inte automatiskt till int
        antal = (int)bredd; //Går bra. Typomvandling sker för att vi ber om det.
        //Omvandlingen ovan skert på eget ansvar. Finns decimaler slängs de bara bort.
 
        //Typomvandling från tal till text kan ske automatiskt som när vi skrev ut
        //dubbla antalet ovan. Annars går det ju inte att addera en text och ett tal
        //Vi tilldelning går det dock inte av sig själv. Efterrsom String är en
        // sammansatt typ kan vi inte bara skriva (String)bredd uta istället: 
        String breddSomText = Double.toString(bredd);
        //Här har vi skapat en ny variabel och gett den ett värde.
        //Double med stort D är en klass som bland annat innehåller metoden toString()
        //Se sid 32 för andra liknande omvandlingar.
        System.out.println(breddSomText+" <--bredden omvandlad till text");
        
        //Nu lite om typen char. En char innehåller precis ett tecken.
        //(En String har valfritt antal tecken). 
        //Skriv ut ett trecken
        System.out.println(tecken);
        //Man kan plocka ut en tecken ur en sträng såhär:
        initial = minText.charAt(0); // Första tecknet har index 0, andra 1 osv.
        System.out.println(minText + " har initialen " + initial);
        
        //Vår Scanner har ingen metod för att läsa in endast ett tecken.
        //Istället får man läsa in ett helt ord med next() och plocka ut det
        //första tecknet
        System.out.println("Vill du skriva ut (j/n)?");
        //Användaren skriver nu j eller n och trycker Enter
        tecken = input.next().charAt(0);
        //Raden ovan betyder: Ta Scannern input och utför dess metod next().
        //Ta sedan resultatet (som är en String) och utför dess metod charAt().
        //Tilldela tillsist resultatet av det (en char) till variabeln tecken.
        
        //Nu ska vi använda vår boolean-variabel som kan vara sann eller falsk.
        skaSkrivaUt = (tecken=='j');
        //Koden inom parentesen körs först. Där jämförs char-variabeln tecken
        //med tecknet 'j' (obs enkel ' för char, inte " som för strängar).
        //Jämförelse av variabler (ej sammansatta typer som String) sker med 
        //dubbla likamed-tecken (==) för att skilja det från tilldelning (=)
        //Jämförelsen blir sann (om tecken innehåller 'j') eller falsk.
        //Resultate lagras boolean-variabeln.
        
        //Vi skriver ut värde (skrivs ut som true eller false)
        System.out.println("Värde på boolean-variabel: " + skaSkrivaUt);
        
        //Sannt eller falskt är vad som behövs i en if-sats (kap 7)
        if(skaSkrivaUt) {
            //Kod som körs om skaSkrivaUt är sann
            System.out.println("Du valde att skriva ut denna text!");
            System.out.println("Här får du en rad till :)");
        }
        
        //Till sist typomvandling med tecken-variabler (char).
        //Varje char lagras som ett 16 bitars heltal.
        //Vid utskrift tolkas heltalet som ett tecken enligt standarden Unicode.
        //Googla gärna fram en längre teckentabell än den på s 37.
        //Vi skriver ut tecknet från användaren:
        System.out.print("Du skrev tecknet ");
        System.out.println(tecken);
        
        //Om vi typomvandlar till int får vi istället se teckenkoden
        System.out.print("Det har teckenkoden ");
        System.out.println((int)tecken);
        
        //Vi testar åt andra hållet:
        System.out.println("Skriv in en teckenkod!");
        tecken=(char)input.nextInt();
        System.out.print("Tecken: ");
        System.out.println(tecken);
        
        
        /* Efter detta exempel, läs kapitel 2. Några saker att kolla:
        Svaret till ÖF 2.2b) på sid 29. Använd normalt inte float!
        Läs om inmatning med nextLine() i avsnitt 2.4 och sedan i min text
        "Inmatning med klassen Scanner" på Onedrive.
        Hoppa över s 33 som hör mer till kap 4
        Läs om namngivning i Java på Onedrive.
        */
    }

}
