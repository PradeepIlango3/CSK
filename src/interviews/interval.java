package interviews;

import java.util.Arrays;

/*class CalenderChecker {
  long[][] events;
  public CalenderChecker(long[][] events) {
    this.events = events;
  }
  public boolean isThereConflict(long[] inputEvent) {
    for (long[] event: events) {
      if (doesOverlap(event, inputEvent)) {
        return true;
      } 
    }
    return false;
  }
  private boolean doesOverlap(long[] eventA, long[] eventB) {
    return (Math.min(eventA[1], eventB[1]) > Math.max(eventA[0], eventB[0]);
  }
}
       */
            
 class CalenderChecker {
  long[][] events;
  public CalenderChecker(long[][] events) {
    this.events = events;
    Arrays.sort(events, (a, b) -> Long.compare(a[0], b[0]));
  }
  public boolean isThereConflict(long[] inputEvent) {
    if (events.length == 0) return false;
    int index = findImmidiateNext(events, inputEvent);
    if (index == events.length) {
      return doesOverlap(events[events.length-1], inputEvent);
    } else if (index ==0) {
      return doesOverlap(events[0], inputEvent);
    } else {
      return doesOverlap(events[index-1], inputEvent) && doesOverlap(events[index], inputEvent);
    }
  }
   
  private int findImmidiateNext(long[][] events, long[] inputEvent) {
    int index = events.length;
    int l = 0;
    int h = events.length - 1;
    while (l <= h) {
      int m = l + (h-l)/2;
      if (events[m][0] > inputEvent[0]) {
        index = m;
        h = m-1;
      }
      else if (events[m][0] < inputEvent[0]) {
        l =m+1;
      } else {
        h = m-1;
      }
    }
    return index;
  }
   
  private boolean doesOverlap(long[] eventA, long[] eventB) {
    return (Math.min(eventA[1], eventB[1]) > Math.max(eventA[0], eventB[0]));
  }
}

            
            
            /*Time Complexity:
            
            
            
            Problem:
            
            team calender : set of calenders
            input event: 
            1 person
            
            team size is growing big
            
            inputEvent e 
            
            person A 
            
            a --- b
                 
            person B
              c ------d 
            
            person C 
            
                        e ---- d
            
            




 a-------b
 
      c------d 
      
      
      
      a----b.   
           c----d

            
            
            a - b 
                   c-d
                     e-f
            
            
                       
            
            
            1. Precomputaion:
                 parse all the calenders and store free time of employees. ex: 3 - 4 , 3 - 5, 4, 6     
                    TreeMap<Long, Long> freeSlots ;
            
            
            Range: 3 -- 6  
            
            
            4 -- 5
            
            
            TreeMap
            
            3 6
            
            
            
            4 5.  
            
            
            4
            
            2. check the input start and end if present 
                      Map.Entry<Integer, Integer> entry = freeSlots.floorEntry();
            
                      chechRange(input, entry)
            
            
                      entry.getKey() <= input.start && entry.getVlaue() >= input.end
                                                
*/