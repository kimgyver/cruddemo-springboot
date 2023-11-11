# cruddemo-springboot

### Instructor : InstructorDetail => 1 : 1
  - Fetch - Eager
  - Cascade - set to Detach/Merge/Persiste/Refresh
  - Caution: when delete instructorDetail => should set instructor's instructDetail to null first


### Instructor : Course => 1 : m  
  - Fetch - Lazy
  - Cascade - set to Detach/Merge/Persiste/Refresh, not including Delete
  - Caution: when delete instructor => should set all courses' instructor to null first


### Student : Course =>  m : m
  - Fetch - Lazy
  - Cascade - set to Detach/Merge/Persiste/Refresh, not including Delete


### Course : Review => 1 : m
  - Fetch - Lazy
  - Cascade - set to all including Delete


====================


JOIN FETCH
  - fetches data from other tables eagerly when lazy fetch mode is set.
![image](https://github.com/kimgyver/cruddemo-springboot/assets/23451818/d305f8d8-3164-4ab7-9c77-9cacf2e9fda5)
