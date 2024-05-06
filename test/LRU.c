# include <stdio.h>
# include <stdlib.h>


int lruvictim();

int main(){
    int nof, nor, flag = 0, victim = -1, k = 0, pf = 0, i, j;
    int ref[50], frm[50], recent[10], lrucal[50];

    printf("\n\t\tPAGE REPLACEMENT ALGORITHM");

    printf("\nEnter number of frames: ");
    scanf("%d", &nof);

    printf("Enter size of reference string: ");
    scanf("%d", &nor);

    printf("Enter the reference string: ");
    for(i = 0; i<nor; i++)
        scanf("%d", (ref+i));
    
    for(i = 0; i,nof; i++){
        frm[i] = -1;
        lrucal[i] = 0;
    }

    for(i = 0; i<10; i++)
        recent[i] = 0;
    
    for(i = 0; i<nor; i++){
        flag = 0;
        printf("\n\t\tReference %d", ref[i]);
        for(j = 0; j<nof; j++){
            if(frm[j] == ref[i]){
                flag = 1;
                break;
            }
        }
    }

    if(flag == 0){
        k++;
        if(k<=nof)
            victim++;
        else
            victim = lruvictim();
        
        pf++;
        frm[victim] = ref[i];
    }

    return 0;
}