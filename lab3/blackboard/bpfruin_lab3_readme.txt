Brian Fruin

Lab 3

Language: Java

This program is very incomplete and not a good implementation of what was asked for.  That said, I did my best in the limited time I have.

I'm not too proud of this program.  It's probably the ugliest code I've ever written. If I had more time, it would be a much better program.  I'd implement assumptions, affirmations, assertions, and dependents as well as make better knowledge sources and have a much better tuned controller.


I use a JAR to access the API.  It is included with the source files. Theres a few bugs I encountered using it, the similarTrack() method returns tracks where all the duration fields match the song passed in, so the same first song is recommended each time.  Also, the getPosition() method returns some strange results as well.

I have a bad headache at the time of this writing so the content is pretty sparse...

********Tracks selected randomly to add to the pool so different songs will be recommended with each run but the recommendations themselves are not random.  the are decided by the heuristics defined by the knowledge sources.

Questions:

1. The pieces of my blackboard are the blackboard, the controller, and the knowledge sources.

2. Adding a new knowlege source is easy.  Just make a new class, implement the KnowledgeSource iterface and plug the new knowlege source into the controller.

3.  My controller goes through the knowledge sources in a loop and has them make contributions to the blackboard and to assess the data already on the blackboard.

4.  I did not implement assumptions and affirmations.

5.  I did not implement dependents.  I wanted to keep the implementation simple.


1.  I differentiate between tracks by comparing the durations of blackboard tracks with the track the user provided.

2. The user is a knowlege source.  The user impacts the pool of tracks on the blackboard.

3. The track to recommend next come from a field on the blackboard.  The track the user likes is specified by the user at runtime.  The track to recommend gets updated every time a knowlege source is called and it finds it has something to contribute.  Each knowlege source influences the blackboard by adding tracks to the pool of possible tracks and by updating the recommended song when appropriate.