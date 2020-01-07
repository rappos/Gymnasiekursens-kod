package sortering;

//Klass som innehåller metoder för sortering av arrayer
public class Sort {
    
    //Skapa en slumpmässig array med doubles (n stycken)
    public static double[] getRandomDoubleArray(int n){
        double[] array =new double[n];
        for(int i=0;i<n;i++) array[i]=Math.random();
        return array;
    }
    
    //Enklast möjliga bubbelsortering av arrayen data
    //Sorterar de första n talen i arrayen data
    //n är alltså antalet element att sortera
    public static void bubbleSortSimple(double[] data,int n){
        for(int j=0;j<n-1;j++){ //Kör n-1 varv
            for(int i=0;i<n-1;i++) {
                //i pekar på det element som ska jämföras med sin granne.
                //Byt plats om element i och i+1 ligger i fel ordning (bokstavsordn)
                if(data[i]>data[i+1]) swap(data, i,i+1);
            }
        }
    }
    
    //Samma som ovan men för arrayer av strängar
    public static void bubbleSortSimple(String[] data,int n){
        for(int j=0;j<n-1;j++){ //Kör n-1 varv
            for(int i=0;i<n-1;i++) {
                //i pekar på det element som ska jämföras med sin granne.
                //Byt plats om element i och i+1 ligger i fel ordning (bokstavsordn)
                if(data[i].compareToIgnoreCase(data[i+1])>0) swap(data, i,i+1);
            }
        }
    }
    
    //Dubbelt så snabb bubbelsortering av arrayen data.
    //Utnyttjar att det bildas en sorterad del av arrayen vid
    //dess slut. Efter två varv är t ex de tyvå största elementen
    //redan sorterade vid arrayens slut.
    //Sorterar de första n talen i arrayen data
    //n är alltså antalet element att sortera
    public static void bubbleSort(double[] data,int n){
        int lastUnsorted=n-1; //Index till det sista osorterade elementet.
        //I början är det det sista elementet (n-1).
        for(;lastUnsorted>0;lastUnsorted--){ //Antalet osorterade minskar med ett varaje varv
            //De sorterade elementen ligger i slutet efter lastUnsorted.
            for(int i=0;i<lastUnsorted;i++) {//Räkna upp i från noll så att det sista varvet
                //pekar på elementet före det sista osorterade.
                //i pekar nu på det första elementet av två att jämföra
                if(data[i]>data[i+1])	//Om element i och element i+1 ligger i fel ordning...
                    swap(data, i, i+1);	//... byt plats på dem!
            }
        }
    }
    
    //Selection sort (utväljande sortering)
    //Sorterar de första n talen i arrayen data
    //n är alltså antalet element att sortera
    public static void selectionSort(double[] data, int n){
        //Algoritmen lägger först de minsta elementen i ordning i början av arrayen.
        //firstUnsorted nedan är det första osorterade elementet
        for(int firstUnsorted=0;firstUnsorted<n;firstUnsorted++){
            //Finn nu det minsta osorterade elementet
            //Peka ut det med variabeln position
            int position=firstUnsorted; //Pekar på minsta elementet hittat hittills
            for(int i=position+1;i<n;i++){ //Gå igenom alla osorterade element
                //Kolla om plats i innehåller ett mindre elementet än det hittills minsta
                if(data[i]<data[position]){
                    position=i;	//plats i har det minsta elementet hittills
                }
            }
            //Position pekar nu på minsta osorterade elementet
            if(firstUnsorted!=position) swap(data,firstUnsorted,position);
        }
    }
    
    //Insertion sort (infogande sortering)
    //Sorterar de första n talen i arrayen data
    //n är alltså antalet element att sortera
    public static void insertionSort(double[] data, int n){
        //Början av listan sorteras genom att vi sätter in
        //ett element i taget från den osorterade delen av listan.
        //Vi tar då det första osorterade elementet (firstUnsorted nedan)
        //och sätter in det på rätt plats (som ska pekas ut av i nedan).
        for(int firstUnsorted=1;firstUnsorted<n;firstUnsorted++){
            int i=firstUnsorted; //i är ett index som ska flyttas så att det pekar
            //där ett element ska infogas.
            //Det första osorterade elementet ska sättas in i den sorterade delen:
            double valueToInsert=data[firstUnsorted];
            //Nu flyttar vi i stegvis mot början av listan tills vi hittar rätt
            //plats att sätta in valueToInsert på.
            while(i>0 && data[i-1] > valueToInsert) {
                //valueToinsert ska vara före data[i-1]
                data[i]=data[i-1]; //data[i-1] flyttas mot slutet av listan för att ge plats
                i--; //Nästa varv tittar vi om elementet innan också är större och ska flyttas
            }
            if(i!=firstUnsorted){
                data[i]=valueToInsert;
            }
        }
    }
    
    //Merge sort (sammanslagnings-sortering) (mer avancerad algoritm, använder rekursion).
    //Överkurs.
    //Sorterar talen från index start till index end-1 i arrayen data
    //end-start är alltså antalet element att sortera
    public static void mergeSort(double[] data, int start, int end){
        int n=end-start; //antalet element
        if(n<2) return; //Jobbet är redan gjort om listan har ett element eller mindre!
        int middle=(start+end)/2;//Pekar på mitten
        //Sortera nu övre och undre halvan för sig, och slå sedan samman dem.
        //Sorteringen av halvorna görs genom att denna metod anropar sig själv.
        //Detta kallas rekursion. Denna metod är alltså rekursiv.
        mergeSort(data,start,middle); //Sortera undre halvan för sig...
        mergeSort(data,middle,end); //...och den övre halvan för sig
        int i1=0; //index till nästa element i undre halvan
        int i2=0; //index till nästa element i övre halvan
        double[] sortedData=new double[n];
        //Slå samman övre och undre halvan till  arrayen sortedData
        //(i nedan pekar på nästa element i sortedData)
        for(int i=0;i<n;i++){
            if(start+i1<middle && middle+i2<end){
                //Det finns element kvar i både undre och övre halvan
                //Ta ett element från den halvan som har det minsta elementet
                if(data[start+i1]<=data[middle+i2]){
                    //Nästa element i undre halvan är mindre än eller lika med nästa
                    //element i övre halvan. Använd undre halvan.
                    sortedData[i]=data[start+i1];
                    i1++;
                } else {
                    //Nästa element i övre halvan är mindre än nästa element i undre halvan
                    //Använd övre halvan.
                    sortedData[i]=data[middle+i2];
                    i2++;
                }
            } else if(middle+i2==end){
                //Element i övre halvan slut, använd undre halvan
                sortedData[i]=data[start+i1];
                i1++;
            }  else {
                //Element i undre halvan slut, använd övre halvan
                sortedData[i]=data[middle+i2];
                i2++;
            }
        }
        //Kopiera resultatet tillbaka till data
        for(int i=0;i<n;i++){
            data[start+i]=sortedData[i];
        }
    }
    
    public static void swap(double[] data,int i,int j)
    {
        double temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
    
    public static void swap(String[] data,int i,int j)
    {
        String temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
    
}
