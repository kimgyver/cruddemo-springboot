# cruddemo-springboot

### Instructor : InstructorDetail => 1 : 1
  - Fetch - Eager
  - Cascade 
    - Instructor -> InstructorDetail : All
    - InstructorDetail -> Instructor : Set to Detach/Merge/Persist/Refresh
  - Caution: when delete instructorDetail => should set instructor's instructDetail to null first


### Instructor : Course => 1 : m  
  - Fetch - Lazy
  - Cascade
    - Instructor -> Course : Set to Detach/Merge/Persist/Refresh, not including Delete
    - Course -> Instructor : Set to Detach/Merge/Persist/Refresh, not including Delete
  - Caution: when delete instructor => should set all courses' instructor to null first


### Student : Course =>  m : m
  - Fetch - Lazy
  - Cascade
    - Student -> Course : Set to Detach/Merge/Persist/Refresh, not including Delete
    - Course -> Student : Set to Detach/Merge/Persist/Refresh, not including Delete


### Course : Review => 1 : m
  - Fetch - Lazy
  - Cascade 
    - Course -> Review : Set to all including Delete


====================


JOIN FETCH
  - fetches data from other tables eagerly when lazy fetch mode is set.
![image](https://github.com/kimgyver/cruddemo-springboot/assets/23451818/d305f8d8-3164-4ab7-9c77-9cacf2e9fda5)
