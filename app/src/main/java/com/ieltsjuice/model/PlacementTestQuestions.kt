package com.ieltsjuice.model

object PlacementTestQuestions{

    fun getQuestions():ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 = Question(1,"1. Is she ____ history teacher?","Maria","Marias'","Maria's","",3,1)
        val que2 = Question(2,"2. Bob will meet ____ at the airport.","us","we","our","",1,1)
        val que3 = Question(3,"3. I'm going to a concert tonight. ____ you like to come?","Do","Would","Are","",2,1)
        val que4 = Question(4,"4. A: ____ use your dictionary? \nB: Sure. Here you are.","Could I","Could you","Do I","",1,1)
        val que5 = Question(5,"5. I like this apartment, but the ____ is too expensive for me.","money","rent","cost","",2,1)
        val que6 = Question(6,"6. Excuse me, how do I ____ to the bus station?","come","get","arrive","",2,1)
        val que7 = Question(7,"7. A: Do you sell stamps?  \nB: Yes, we do. How ____ do you want?","any","many","much","",2,1)
        val que8 = Question(8,"8. A: Sorry I'm so late. \nB: That's ____ .","OK","great","right","",1,1)
        val que9 = Question(9,"9. I'd like ____ milk in my coffee, please.","some","any","a","",1,1)
        val que10 = Question(10,"10. ____ a bus stop near my flat.","It's","Here's","There's","",3,1)
        val que11 = Question(11,"11. A: Is this a good time to talk? \nB: Sorry, no. I ____ dinner.","cook","am cooking","cooking","",2,1)
        val que12 = Question(12,"12. I think cycling is more dangerous ____ driving.","as","like","than","",3,1)
        val que13 = Question(13,"13. We ____ going to the theater next Saturday.","will","do","are","",3,1)
        val que14 = Question(14,"14. ____ meet for coffee some time soon.","Let's","Do we","Shall we","",1,1)
        val que15 = Question(15,"15. Robert has got a holiday home near ____ sea.","a","the","—","",2,1)
        val que16 = Question(16,"16. If you've got a headache, you ____ go home.","should","ought","had","",1,1)
        val que17 = Question(17,"17. ____ ever been to New York?","Have you","Are you","Did you","",1,1)
        val que18 = Question(18,"18. I only get about five hours' sleep a night. That's not ____ .","enough","lot","too much","",1,1)
        val que19 = Question(19,"19. A: Did George finish the report?  \nB: No. He ____ it tomorrow.","finishes","is going to finish","finished","",2,1)
        val que20 = Question(20,"20. Paula ____ loves working with children.","very","really","much","",2,1)
        val que21 = Question(21,"21. A: Is Ottawa the capital of Canada? \nB: I think ____ .","is","ok","so","right",3,1)
        val que22 = Question(22,"22. We never ____ a television when I was a child.","have had","hadn't","had","didn't have",3,1)
        val que23 = Question(23,"23. We paid the restaurant bill ____ credit card.","to","with","on","by",4,1)
        val que24 = Question(24,"24. The last time I ____ Joanna was in Paris.","have seen","saw","see","had seen",2,1)
        val que25 = Question(25,"25. If you ____ money from a friend, you should always pay it back promptly.","borrow","earn","spend","lend",1,1)
        val que26 = Question(26,"26. A: Can I make myself a cup of coffee? \nB: Of course. You ____ to ask.","haven't","mustn't","needn't","don't have",4,1)
        val que27 = Question(27,"27. I ____ a lot of sport in my free time.","do","practise","make","exercise",1,1)
        val que28 = Question(28,"28. ____ anywhere interesting recently?","Do you go","Have you been","Are you going","Will you go",2,1)
        val que29= Question(29,"29. It's Walter's birthday on Friday. He ____ be 30, I think.","should","can","will","shall",3,1)
        val que30= Question(30,"30 . Learning the piano isn't as difficult ____ learning the violin.","like","so","than","as",4,1)
        val que31= Question(31,"31. If the weather ____ bad tomorrow, we can go to a museum.","will be","was","is","would be",3,1)
        val que32= Question(32,"32. About a billion cans of Coca-Cola ____ drunk around the world every day.","is","are","was","were",2,1)
        val que33= Question(33,"33. A: My wife's not very well. \nB: Oh, ____.","it doesn't matter","I do apologize","sorry to hear that","not bad, thanks.",3,1)
        val que34= Question(34,"34. Hans isn't here. He ____ to see his grandmother. He'll be back tomorrow.","has gone","had been","has been","had gone",1,1)
        val que35= Question(35,"35. Would you mind changing my appointment? ____ time on Friday is fine.","Next","All the","Every","Any",4,2)
        val que36= Question(36,"36. When I was a child, I ____ climb the wall and jump into our neighbours' garden.","would","had","have","used",1,1)
        val que37= Question(37,"37. Have you finished ____ the wall yet?","paint","to paint","painting","painted",3,1)
        val que38= Question(38,"38. Can you help me? I've tried ____ hotel in the city and can't find a room.","many","any","every","all",3,2)
        val que39= Question(39,"39. Lena used to find work boring ____ she became a nurse.","unless","until","if","since",2,1)
        val que40= Question(40,"40. If I ____ closer to my office, I could walk to work.","lived","would live","had lived","live",1,1)
        val que41= Question(41,"41. I ____ outside the cinema when suddenly a police car arrived.","stood","was standing","have stood","am standing",2,1)
        val que42= Question(42,"42. A: Shall we go to The Riceboat for dinner? \nB: It ____ be fully booked. They're sometimes busy on Mondays.","will","may","can","must",2,2)
        val que43= Question(43,"43. We've ____ come back from a trip to India. It was amazing.","already","yet","just","only",3,1)
        val que44= Question(44,"44. I've got to be at work in five minutes. Don't worry, I ____ you a lift if you want.","give","am giving","'ll give","'m going to give",3,1)
        val que45= Question(45,"45. My doctor advised me ____ more exercise.","take","taking","having taken","to take",4,1)
        val que46= Question(46,"46. I couldn't ____ up with the noise in the city, so we moved to the countryside.","put","live","set","take",1,1)
        val que47= Question(47,"47. There's no name on this dictionary. It ____ be mine then. Mine's got my name on the front.","might not","mustn't","won't","can't",4,1)
        val que48= Question(48,"48. Julia ____ married since she was 20.","is","was","has been","is being",3,1)
        val que49= Question(49,"49. Don't worry if I ____ late tonight. I'm going to the gym after work.","am","will be","would be","was",1,2)
        val que50= Question(50,"50. A: I've got a terrible headache, and it won't go away. \nB: Have you tried ____ some aspirin?","to take","take","took","taking",4,1)
        val que51= Question(51,"51. Boxing is a sport ____ requires a lot of speed and fitness.","it","that","what","where",2,1)
        val que52= Question(52,"52. John ____ working on this project for a couple of months so he hasn't made much progress yet.","is only","has only been","was only","had only been",2,1)
        val que53= Question(53,"53. A: I was wondering ____ I could ask you some questions. \nB: Sure, go ahead.","what","if","that","how",2,1)
        val que54= Question(54,"54. A: What clothes should I pack for a trip to Boston? \nB: Well, it depends ____ the time of year that you go.","on","with","up","to",1,1)
        val que55= Question(55,"55. I've finished this salad and I'm still hungry. I ____ ordered something more filling.","must have","would have","should have","may have",3,1)
        val que56= Question(56,"56. Do you ever ask your neighbours to do favours ____ you?","for","to","with","about",1,1)
        val que57= Question(57,"57. Some married couples seem to get more -____ over time.","alike","same","like","equal",1,1)
        val que58= Question(58,"58. I don't know how much this cup costs. The price label's ____ off.","gone","taken","done","come",4,1)
        val que59= Question(59,"59. Katie got the job because she ____ a very good impression at her interview.","made","did","put","took",1,1)
        val que60= Question(60,"60. Salsa music always ____ me of my trip to Cuba.","remembers","realizes","recognizes","reminds",4,1)
        val que61= Question(61,"61. I ____ to be picking Tom up at the station but I've lost my keys.","am supposed","am requested","am intended","am obliged",1,1)
        val que62= Question(62,"62. How about going to Colours nightclub? There's no ____ I'm going there. It's awful!","hope","way","time","opportunity",2,1)
        val que63= Question(63,"63. By the age of 18, I ____ not to go to university.","had decided","decided","have decided","was deciding",1,1)
        val que64= Question(64,"64. I'm afraid your car ____ repaired before next week.","hasn't been","wasn't","wouldn't be","can't be",4,1)
        val que65= Question(65,"65. The amount of organically grown food on sale has ____ enormously in recent years.","raised","lifted","increased","built",3,1)
        val que66= Question(66,"66. Can you believe it? A woman has been ____ for hacking into the computer of her online virtual husband.","accused","suspended","arrested","suspected",3,1)
        val que67= Question(67,"67. You may borrow my laptop ____ you promise to look after it.","unless","in case","as long as","although",3,1)
        val que68= Question(68,"68. It's a huge painting. It ____ taken ages to complete.","must have","can't have","should have","won't have",1,1)
        val que69= Question(69,"69. Pierre tends to put ____ dealing with problems, rather than dealing with them immediately.","down","off","over","away",2,1)
        val que70= Question(70,"70. If the taxi hadn't stopped for us, we ____ standing in the rain.","were still","would still be","are still","will still be",2,1)
        val que71= Question(71,"71. My mother's Italian, so ____ the language has been quite easy for me.","to learn","learn","having learned","learning",4,1)
        val que72= Question(72,"72. ____ I had the talent, I still wouldn't want to be a movie star.","In case","Even if","Provided that","However much",2,1)
        val que73= Question(73,"73. The factory workers threatened ____ on strike if they didn't get a pay rise.","going","to go","that they go","to have gone",2,1)
        val que74= Question(74,"74. I was about to go to sleep when it ____ to me where the missing keys might be.","remembered","happened","appeared","occurred",4,1)
        val que75= Question(75,"75. There's going to be a new department at work. They've asked me to ____ it up.","take","set","out","bring",2,1)
        val que76= Question(76,"76. If the film is a ____ success, the director will get most of the credit.","big","high","large","good",1,1)
        val que77= Question(77,"77. By the end of today's seminar I will ____ to each of you individually.","speak","have spoken","be speaking","have been speaking",2,1)
        val que78= Question(78,"78. This is a photo of my little sister ____ ice cream on the beach.","eat","eating","was eating","having eaten",2,1)
        val que79= Question(79,"79. Our students take their responsibilities very ____.","considerably","thoroughly","seriously","strongly",3,1)
        val que80= Question(80,"80. Pia was ____ delighted with the birthday present.","very","completely","fairly","absolutely",4,1)
        val que81= Question(81,"81. People were amazed that the burglary took place in ____ daylight.","wide","broad","large","open",2,2)
        val que82= Question(82,"82. She invested a lot of time ____ researching the most appropriate university course.","to","for","on","in",4,1)
        val que83= Question(83,"83. The police claimed that they acted in self- ____.","interest","confidence","defence","discipline",3,1)
        val que84= Question(84,"84 . I ____ remember putting my briefcase down on that shelf.","deeply","entirely","clearly","strongly",3,1)
        val que85= Question(85,"85. She turned ____ to be considerably older than I had imagined.","over","up","out","round",3,1)
        val que86= Question(86,"86. The windows in this house are in urgent ____ of replacement.","need","help","want","demand",1,1)
        val que87= Question(87,"87. Speed cameras ____ shown to reduce accidents.","have","were being","have been","are being",3,1)
        val que88= Question(88,"88. Life is a ____ deal easier for immigrants who can speak the local language.","far","huge","big","great",4,1)
        val que89= Question(89,"89. The experiment ____ testing people's responses before and after drinking coffee.","contained","incorporated","involved","consisted",3,1)
        val que90= Question(90,"90. We may be a bit late. We're ____ in a traffic jam.","buried","stuck","blocked","surrounded",2,1)
        val que91= Question(91,"91. Having ____ his driving test several times, Paul finally passed at the fourth attempt.","taken","made","had","attended",1,1)
        val que92= Question(92,"92. Gospel music has been a major influence ____ other musical styles, especially soul.","with","to","about","on",4,1)
        val que93= Question(93,"93. Maintaining an accurate balance sheet is essential ____ business you're in.","however","whenever","whatever","wherever",3,1)
        val que94= Question(94,"94. It's ____ likely that this novel will win a literary prize.","totally","deeply","strongly","highly",4,1)
        val que95= Question(95,"95. It’s no ____ for me to get Brad’s phone number. I’ll be seeing him tonight.","point","wonder","secret","problem",4,1)
        val que96= Question(96,"96. I'd lived in Australia, so I was used to ____ on the left side of the road.","driving","drive","having driven","drove",1,1)
        val que97= Question(97,"97. I don't think the colours in Julia's outfit ____ together.","fit","suit","match","go",4,2)
        val que98= Question(98,"98. Very rarely ____ here in July.","it rains","does it rain","is it raining","it is raining",2,2)
        val que99= Question(99,"99. I prefer to buy CDs ____ download music from my computer.","in contrast to","as opposed to","rather than","in comparison to",3,1)
        val que100= Question(100,"100. The number of turtles on the island ____ by 70% over the last decade.","has declined","has been declining","has been declined","is declining",1,2)

        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        questionList.add(que4)
        questionList.add(que5)
        questionList.add(que6)
        questionList.add(que7)
        questionList.add(que8)
        questionList.add(que9)
        questionList.add(que10)
        questionList.add(que11)
        questionList.add(que12)
        questionList.add(que13)
        questionList.add(que14)
        questionList.add(que15)
        questionList.add(que16)
        questionList.add(que17)
        questionList.add(que18)
        questionList.add(que19)
        questionList.add(que20)
        questionList.add(que21)
        questionList.add(que22)
        questionList.add(que23)
        questionList.add(que24)
        questionList.add(que25)
        questionList.add(que26)
        questionList.add(que27)
        questionList.add(que28)
        questionList.add(que29)
        questionList.add(que30)
        questionList.add(que31)
        questionList.add(que32)
        questionList.add(que33)
        questionList.add(que34)
        questionList.add(que35)
        questionList.add(que36)
        questionList.add(que37)
        questionList.add(que38)
        questionList.add(que39)
        questionList.add(que40)
        questionList.add(que41)
        questionList.add(que42)
        questionList.add(que43)
        questionList.add(que44)
        questionList.add(que45)
        questionList.add(que46)
        questionList.add(que47)
        questionList.add(que48)
        questionList.add(que49)
        questionList.add(que50)
        questionList.add(que51)
        questionList.add(que52)
        questionList.add(que53)
        questionList.add(que54)
        questionList.add(que55)
        questionList.add(que56)
        questionList.add(que57)
        questionList.add(que58)
        questionList.add(que59)
        questionList.add(que60)
        questionList.add(que61)
        questionList.add(que62)
        questionList.add(que63)
        questionList.add(que64)
        questionList.add(que65)
        questionList.add(que66)
        questionList.add(que67)
        questionList.add(que68)
        questionList.add(que69)
        questionList.add(que70)
        questionList.add(que71)
        questionList.add(que72)
        questionList.add(que73)
        questionList.add(que74)
        questionList.add(que75)
        questionList.add(que76)
        questionList.add(que77)
        questionList.add(que78)
        questionList.add(que79)
        questionList.add(que80)
        questionList.add(que81)
        questionList.add(que82)
        questionList.add(que83)
        questionList.add(que84)
        questionList.add(que85)
        questionList.add(que86)
        questionList.add(que87)
        questionList.add(que88)
        questionList.add(que89)
        questionList.add(que90)
        questionList.add(que91)
        questionList.add(que92)
        questionList.add(que93)
        questionList.add(que94)
        questionList.add(que95)
        questionList.add(que96)
        questionList.add(que97)
        questionList.add(que98)
        questionList.add(que99)
        questionList.add(que100)

        return questionList
    }
}