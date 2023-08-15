package com.example.mylibrary.pvsrishabh;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static final String ALL_BOOKS_KEY = "all_books";
    private static final String ALREADY_READ_BOOKS = "already_read_books";
    private static final String WANT_TO_READ_BOOKS = "want_to_read_books";
    private static final String CURRENTLY_READING_BOOKS = "currently_reading_books";
    private static final String FAVORITE_BOOKS = "favorite_books";

    private static  Utils instance;
    private SharedPreferences sharedPreferences;

    private Utils(Context context) {

        sharedPreferences = context.getSharedPreferences("alternate_db",Context.MODE_PRIVATE);

        if (null == getAllBooks()){
            initData();
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (null == getAlreadyReadBooks()){
            editor.putString(ALREADY_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getWantToReadBooks()){
            editor.putString(WANT_TO_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getCurrentlyReadingBooks()){
            editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getFavoriteBooks()){
            editor.putString(FAVORITE_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
    }

    private void initData() {

        ArrayList<Book> books = new ArrayList<>();

        String ld1 = "Louvre curator and Priory of Sion grand master Jacques Saunière is fatally shot one night at the museum by an albino Catholic monk named Silas, who is working on behalf of someone he knows only as the Teacher, who wishes to discover the location of the \"keystone,\" an item crucial in the search for the Holy Grail.\n" +
                "\n" +
                "After Saunière's body is discovered in the pose of the Vitruvian Man by Leonardo da Vinci, the police summon Harvard professor Robert Langdon, who is in town on business. Police captain Bezu Fache tells him that he was summoned to help the police decode the cryptic message Saunière left during the final minutes of his life. The message includes a Fibonacci sequence out of order and an anagram 'O, draconian devil Oh, lame saint'.\n" +
                "\n" +
                "Langdon explains to Fache that the pentacle Saunière drew on his chest in his own blood represents an allusion to the goddess and not devil worship, as Fache believes.\n" +
                "\n" +
                "Sophie Neveu, a police cryptographer, secretly explains to Langdon that she is Saunière's estranged granddaughter and that Fache thinks Langdon is the murderer because the last line in her grandfather's message, which was meant for Neveu, said \"P.S. Find Robert Langdon,\" which Fache had erased prior to Langdon's arrival. However, \"P.S.\" does not refer to \"postscript\", but rather to Sophie — the nickname given to her by her grandfather was \"Princess Sophie\". She understands that her grandfather intended Langdon to decipher the code, which leads to Leonardo da Vinci's Mona Lisa, which in turn leads to his painting Madonna of the Rocks. They find a pendant that holds the address of the Paris branch of the Depository Bank of Zurich.\n" +
                "\n" +
                "\n" +
                "Replica cryptex: prize from Google Da Vinci Code Quest Contest\n" +
                "Neveu and Langdon escape from the police and visit the bank. In the safe deposit box, they find a box containing the keystone: a cryptex, a cylindrical, hand-held vault with five concentric, rotating dials labeled with letters. When these are lined up correctly, they unlock the device. If the cryptex is forced open, an enclosed vial of vinegar breaks and dissolves the message inside the cryptex, which was written on papyrus. The box containing the cryptex contains clues to its password.\n" +
                "\n" +
                "Langdon and Neveu take the keystone to the home of Langdon's friend, Sir Leigh Teabing, an expert on the Holy Grail, the legend of which is heavily connected to the Priory. There, Teabing explains that the Grail is not a cup, but connected to Mary Magdalene, and that she was Jesus Christ's wife and is the person to his right in The Last Supper.\n" +
                "\n" +
                "The trio then flees the country on Teabing's private plane, on which they conclude that the proper combination of letters spells out Neveu's given name, Sofia. Opening the cryptex, they discover a smaller cryptex inside it, along with another riddle that ultimately leads the group to the tomb of Isaac Newton in Westminster Abbey.\n" +
                "\n" +
                "During the flight to Britain, Neveu reveals the source of her estrangement from her grandfather ten years earlier: arriving home unexpectedly from university, Neveu secretly witnessed a spring fertility rite conducted in the secret basement of her grandfather's country estate. From her hiding place, she was shocked to see her grandfather with a woman at the center of a ritual attended by men and women who were wearing masks and chanting praise to the goddess. She fled the house and broke off all contact with Saunière. Langdon explains that what she witnessed was an ancient ceremony known as hieros gamos or \"sacred marriage.\"\n" +
                "\n" +
                "By the time they arrive at Westminster Abbey, Teabing is revealed to be the Teacher for whom Silas is working. Teabing wishes to use the Holy Grail, which he believes is a series of documents establishing that Jesus Christ married Mary Magdalene and fathered children, in order to ruin the Vatican. He compels Langdon at gunpoint to solve the second cryptex's password, which Langdon realizes is \"apple.\" Langdon secretly opens the cryptex and removes its contents before tossing the empty cryptex in the air.\n" +
                "\n" +
                "Teabing is arrested by Fache, who by now realizes that Langdon is innocent. Bishop Aringarosa, head of religious sect Opus Dei and Silas' mentor, realizing that Silas has been used to murder innocent people, rushes to help the police find him. When the police find Silas hiding in an Opus Dei Center, Silas assumes that they are there to kill him and he rushes out, accidentally shooting Bishop Aringarosa. Bishop Aringarosa survives but is informed that Silas was found dead later from a gunshot wound.\n" +
                "\n" +
                "The final message inside the second keystone leads Neveu and Langdon to Rosslyn Chapel, whose docent turns out to be Neveu's long-lost brother, who Neveu had been told died as a child in the car accident that killed her parents. The guardian of Rosslyn Chapel, Marie Chauvel Saint Clair, is Neveu's long-lost grandmother. It is revealed that Neveu and her brother are descendants of Mary Magdalene. The Priory of Sion hid her identity to protect her from possible threats to her life.\n" +
                "\n" +
                "The real meaning of the last message is that the Grail is buried beneath the small pyramid directly below the La Pyramide Inversée, the inverted glass pyramid of the Louvre. It also lies beneath the \"Rose Line,\" an allusion to \"Rosslyn.\" Langdon figures out this final piece to the puzzle; he follows the Rose Line (prime meridian) to La Pyramide Inversée, where he kneels to pray before the hidden sarcophagus of Mary Magdalene, as the Templar knights did before.";

        String ld2 = "Chapter 1: An Absurd Reasoning\n" +
                "Camus undertakes the task of answering what he considers to be the only question of philosophy that matters: Does the realization of the meaninglessness and absurdity of life necessarily require suicide?\n" +
                "\n" +
                "He begins by describing the following absurd condition: we build our life on the hope for tomorrow, yet tomorrow brings us closer to death and is the ultimate enemy; people live their lives as if they were not aware of the certainty of death. Once stripped of its common romanticism, the world is a foreign, strange and inhuman place; true knowledge is impossible and rationality and science cannot explain the world: their stories ultimately end in meaningless abstractions, in metaphors. This is the absurd condition and \"from the moment absurdity is recognized, it becomes a passion, the most harrowing of all.\"\n" +
                "\n" +
                "It is not the world that is absurd, nor human thought: the absurd arises when the human need to understand meets the unreasonableness of the world, when the \"appetite for the absolute and for unity\" meets \"the impossibility of reducing this world to a rational and reasonable principle.\"\n" +
                "\n" +
                "He then characterizes several philosophies that describe and attempt to deal with this feeling of the absurd, by Martin Heidegger, Karl Jaspers, Lev Shestov, Søren Kierkegaard, and Edmund Husserl. All of these, he claims, commit \"philosophical suicide\" by reaching conclusions that contradict the original absurd position, either by abandoning reason and turning to God, as in the case of Kierkegaard and Shestov, or by elevating reason and ultimately arriving at ubiquitous Platonic forms and an abstract god, as in the case of Husserl.\n" +
                "\n" +
                "For Camus, who sets out to take the absurd seriously and follow it to its final conclusions, these \"leaps\" cannot convince. Taking the absurd seriously means acknowledging the contradiction between the desire of human reason and the unreasonable world. Suicide, then, also must be rejected: without man, the absurd cannot exist. The contradiction must be lived; reason and its limits must be acknowledged, without false hope. However, the absurd can never be permanently accepted: it requires constant confrontation, constant revolt.\n" +
                "\n" +
                "While the question of human freedom in the metaphysical sense loses interest to the absurd man, he gains freedom in a very concrete sense: no longer bound by hope for a better future or eternity, without a need to pursue life's purpose or to create meaning, \"he enjoys a freedom with regard to common rules\".\n" +
                "\n" +
                "To embrace the absurd implies embracing all that the unreasonable world has to offer. Without meaning in life, there is no scale of values. \"What counts is not the best living but the most living.\"\n" +
                "\n" +
                "Thus, Camus arrives at three consequences from fully acknowledging the absurd: revolt, freedom, and passion.\n" +
                "\n" +
                "Chapter 2: The Absurd Man\n" +
                "How should the absurd man live? Clearly, no ethical rules apply, as they are all based on higher powers or on justification. \"...integrity has no need of rules... 'Everything is permitted,'... is not an outburst of relief or of joy, but rather a bitter acknowledgement of a fact.\"\n" +
                "\n" +
                "Camus then goes on to present examples of the absurd life. He begins with Don Juan, the serial seducer who lives the passionate life to the fullest. \"There is no noble love but that which recognizes itself to be both short-lived and exceptional.\"\n" +
                "\n" +
                "The next example is the actor, who depicts ephemeral lives for ephemeral fame. \"He demonstrates to what degree appearing creates being. In those three hours, he travels the whole course of the dead-end path that the man in the audience takes a lifetime to cover.\"\n" +
                "\n" +
                "Camus's third example of the absurd man is the conqueror, the warrior who forgoes all promises of eternity to affect and engage fully in human history. He chooses action over contemplation, aware of the fact that nothing can last and no victory is final.\n" +
                "\n" +
                "Chapter 3: Absurd Creation\n" +
                "Here Camus explores the absurd creator or artist. Since explanation is impossible, absurd art is restricted to a description of the myriad experiences in the world. \"If the world were clear, art would not exist.\" Absurd creation, of course, also must refrain from judging and from alluding to even the slightest shadow of hope.\n" +
                "\n" +
                "He then analyzes the work of Fyodor Dostoevsky in this light, especially The Diary of a Writer, The Possessed and The Brothers Karamazov. All these works start from the absurd position, and the first two explore the theme of philosophical suicide. However, both The Diary and his last novel, The Brothers Karamazov, ultimately find a path to hope and faith and thus fail as truly absurd creations.\n" +
                "\n" +
                "Chapter 4: The Myth of Sisyphus\n" +
                "In the last chapter, Camus outlines the legend of Sisyphus who defied the gods and put Death in chains so that no human needed to die. When Death was eventually liberated and it came time for Sisyphus himself to die, he concocted a deceit which let him escape from the underworld. After finally capturing Sisyphus, the gods decided that his punishment would last for all eternity. He would have to push a rock up a mountain; upon reaching the top, the rock would roll down again, leaving Sisyphus to start over. Camus sees Sisyphus as the absurd hero who lives life to the fullest, hates death, and is condemned to a meaningless task.[4]\n" +
                "\n" +
                "Camus presents Sisyphus's ceaseless and pointless toil as a metaphor for modern lives spent working at futile jobs in factories and offices. \"The workman of today works every day in his life at the same tasks, and this fate is no less absurd. But it is tragic only at the rare moments when it becomes conscious.\"\n" +
                "\n" +
                "Camus is interested in Sisyphus's thoughts when marching down the mountain, to start anew. After the stone falls back down the mountain Camus states that \"It is during that return, that pause, that Sisyphus interests me. A face that toils so close to stones is already stone itself! I see that man going back down with a heavy yet measured step toward the torment of which he will never know the end.\" This is the truly tragic moment when the hero becomes conscious of his wretched condition. He does not have hope, but \"there is no fate that cannot be surmounted by scorn.\" Acknowledging the truth will conquer it; Sisyphus, just like the absurd man, continues pushing. Camus claims that when Sisyphus acknowledges the futility of his task and the certainty of his fate, he is freed to realize the absurdity of his situation and to reach a state of contented acceptance. With a nod to the similarly cursed Greek hero Oedipus, Camus concludes that \"all is well,\" indeed, that \"one must imagine Sisyphus happy.";

        String ld3 = "Lesson 1: Visualization is a means to use the placebo effect to your advantage.\n" +
                "The central point of the book is that you can use your imagination to suggest ideas to your subconscious to get what you want. If repeated often enough, your mind will then steer your behavior more towards making those ideas a reality, unbeknownst to you. There are many ways you can do this, but most of them can be summarized under the concept of visualization – picturing yourself achieving a certain goal or outcome.\n" +
                "\n" +
                "The scientific idea this plays on is called the placebo effect. In medicine, a placebo is a pill without a real, chemical or biological consequence, usually made of sugar. But if patients believe they’re getting strong medication, they might still observe some of the benefits, solely based on this belief. While the effect has been observed in many studies, I wouldn’t call this hard science, because how well it works is very subjective and depends on the individual.\n" +
                "\n" +
                "Murphy describes many examples in the book, like an opera singer, who used this technique to overcome his stage fright. Another one is a surgeon in the 1900s, who lowered the mortality rate of his patients by telling them they wouldn’t get an infection. There are also many modern-day examples, like actor Jim Carry, who used visualization to succeed as an actor.\n" +
                "\n" +
                "Lesson 2: When in doubt, sleep on it. Often, you can make more confident decisions after a good night’s rest.\n" +
                "Another way you can make use of your subconscious is to simply sleep on things when you have a tough time deciding.\n" +
                "\n" +
                "Murphy’s example is a woman, who was offered a job at the opposite coast of the country. It paid twice her current salary, but she was unsure whether to move across the nation for it. As she meditated in the evening, she fell asleep. In the morning, her gut confirmed her initial doubts and she decided not to take the offer. A few months later, she found out the company had gone bankrupt.\n" +
                "\n" +
                "Now, hindsight is 20/20 and it’s impossible to know how things might’ve changed if she’d taken the job, but the basic premise is valid. Your subconscious can process information quicker and in different ways than your conscious self. Therefore, letting it do its thing while you sleep can lead to clearer thoughts and a more confident opinion the next day.\n" +
                "\n" +
                "Lesson 3: Wish others well, for envy will only prevent you from getting what you want.\n" +
                "While your subconscious can be very useful if steered in the right direction, it can also make you get in your own way.\n" +
                "\n" +
                "Murphy shares the story of a salesman, who never seemed to receive any recognition at work. Despite outperforming all of his colleagues, he didn’t rise in the ranks. As it turned out, he suspected his boss to not like him. Therefore, he subconsciously behaved in somewhat hostile ways himself. Once he changed his own attitude, wishing genuine success for his boss, he soon received a promotion.\n" +
                "\n" +
                "Many rich people share the belief at the root of this story: if you secretly despise others for having something you want, you’ll make it less likely for yourself to attain that thing. Take wealth, for example. If you think money is the root of all evil and that all millionaires are crooks, how do you think that’ll affect the management of your own finances?\n" +
                "\n" +
                "So don’t fall into a victim mindset. The pie isn’t limited. There’s enough to go around for everyone. Stay positive and root for others, so that the universe may root for you.";

        String ld4 = "Harry Potter lives with his abusive aunt and uncle, Vernon and Petunia Dursley and their bullying son, Dudley. On Harry's eleventh birthday, a half-giant named Rubeus Hagrid personally delivers an acceptance letter to Hogwarts School of Witchcraft and Wizardry, revealing that Harry's parents, James and Lily Potter, were wizards. When Harry was one year old, an evil and powerful dark wizard, Lord Voldemort, murdered his parents. Harry survived Voldemort's killing curse that rebounded off his forehead and seemingly destroyed the Dark Lord, leaving a lightning bolt-shaped scar on his forehead. Unknown to Harry, he is famous in the wizarding world.\n" +
                "\n" +
                "Hagrid takes Harry to Diagon Alley, the hidden wizard commerce and retail section in London. Harry's parents have left him a fortune kept in Gringotts Wizarding Bank. Harry buys school supplies and a wand from Ollivander. The cores of Harry and Lord Voldemort's wands have feathers from the same phoenix bird, making them \"brothers\". Hagrid gives Harry an owl that he names Hedwig. A month later, Harry boards the Hogwarts Express at King's Cross railway station's secret Platform 9¾. On the journey to Hogwarts, Harry befriends fellow first-year Ronald Weasley and meets Hermione Granger, whom the two boys initially dislike. Harry runs afoul of first-year student, Draco Malfoy.\n" +
                "\n" +
                "At Hogwarts, a magical Sorting Hat sorts the first-years among four school Houses (Gryffindor, Slytherin, Hufflepuff and Ravenclaw) that best suit their personalities and talents. Draco joins Slytherin, known for dark wizards, while Harry, Ron, and Hermione are sorted into Gryffindor.\n" +
                "\n" +
                "Harry's broomstick flying ability earns him a place on the Gryffindor Quidditch team as the Seeker. Harry comes to dislike Potions master Severus Snape, who favours Slytherin while seeking to fail Harry. Malfoy tricks Harry and Ron into risking expulsion by leaving their common room after curfew. Hermione, unable to stop them, tags along. Realising Malfoy's ruse, they hide in a forbidden corridor and discover a gigantic three-headed dog guarding a trapdoor. Ron and Harry later save Hermione from a troll during the school's Halloween celebration and the three become best friends. Coupled with Snape's recent leg injury and suspicious behaviour, Harry, Hermione and Ron believe he is attempting to enter the trapdoor.\n" +
                "\n" +
                "Hermione warns the boys against investigating further and instead directs Harry's attention to his first Quidditch match. His broomstick's attempts to buck him off and Snape's strange behaviour during the match convinces Hermione he jinxed Harry's broom. Harry receives an anonymous Christmas gift – his father's invisibility cloak. Using it to explore the school, he discovers the Mirror of Erised, which shows what the viewer most desires. Harry sees his parents.\n" +
                "\n" +
                "The trio read a newspaper report about an attempted robbery at Gringotts Bank and the same vault from which Hagrid retrieved an item for the school's headmaster Albus Dumbledore on the same day. They suspect the object beneath the trapdoor is the philosopher's stone, which grants its user immortality and the ability to turn any metal into pure gold. A forest centaur named Firenze warns Harry that Voldemort is plotting to steal the stone to restore his body. When Dumbledore is lured from Hogwarts under false pretences, Harry, Hermione and Ron fear the theft is imminent and descend through the trapdoor.\n" +
                "\n" +
                "A series of obstacles force Ron and Hermione to remain behind while Harry proceeds. Harry encounters Professor Quirrell, the Defence Against the Dark Arts teacher, who reveals that he jinxed Harry's broom and let the troll into the school; Snape was protecting Harry. Voldemort, whose face is attached to the back of Quirrell's head, is using Quirrell to obtain the philosopher's stone. Harry is forced to stand before the Mirror of Erised. It recognises Harry's lack of greed for the stone and deposits it into his pocket. Quirrell attempts to seize the stone and kill Harry, but his flesh burns upon contact with him. Harry's scar begins hurting and he passes out.\n" +
                "\n" +
                "Harry awakens in the school's infirmary. Dumbledore explains Harry survived Voldemort because his mother sacrificing her life for him left a magical protective charm. Quirrell's hatred and greed caused him to burn upon contact with Harry; Voldemort abandoned him to die. Dumbledore reveals he sent Harry the invisibility cloak, while the philosopher's stone, that had been keeping the long-lived Nicolas Flamel alive, has been destroyed to prevent its being stolen. During the school's year-end feast, Gryffindor is awarded the House Cup. Harry returns to the Dursleys at Privet Drive until the next school year.";

        String ld5 = "The story is balanced between a narrative in present day New York City and flashbacks starting from Addie's childhood in France to her experiences traveling the world and witnessing major historical events. It begins in the early 1700s, following Addie as a young woman burdened by a forced marriage and praying to the gods for her freedom. She accidentally catches the attention of a god of the night, who she would later name Luc, who promises her the time she wants with the caveat being nobody will ever remember her after one encounter. Over time she subtly influences many people, making marks in history and inspiring the creation of songs and art about her. Luc visits her every year after they make their deal, asking for her soul, but she refuses every time. The pair develop a relationship over time that carries on for about two decades. It ends abruptly when Luc asks again for her to surrender her soul, as Addie believes their relationship was just a gambit.\n" +
                "\n" +
                "In 2014, Addie meets a man named Henry Strauss who can somehow remember her and speak her name. The pair become romantically involved until the day that Addie realizes that Henry only has 35 days left to live per conditions of his deal with Luc. Due to heavy familial pressures placed on him, Henry felt bogged down in his life, and a failed proposal made him attempt suicide. Luc visited him and granted his wish: whenever someone would see him, they would see what they desire the most. This allowed Henry to remember Addie, fulfilling her wish that somebody would remember her. At the novel's end, Addie sacrifices herself to Luc, agreeing to be his so long as he wants her at his side. She does not surrender her soul as Luc no longer wants it, claiming to be in love with her. Luc agrees to this in exchange for Henry's freedom with Addie's condition that Henry remember her. Henry publishes the stories Addie told him of her past in a book called The Invisible Life of Addie LaRue, which is an instant success. Addie has hope that she can manipulate Luc to let her go and finally have peace.";

        String ld6 = "In spring 1922, Nick Carraway—a Yale alumnus from the Midwest and a World War I veteran—journeys to New York City to obtain employment as a bond salesman. He rents a bungalow in the Long Island village of West Egg, next to a luxurious estate inhabited by Jay Gatsby, an enigmatic multi-millionaire who hosts dazzling soirées yet does not partake in them.\n" +
                "\n" +
                "One evening, Nick dines with a distant relative, Daisy Buchanan, in the fashionable town of East Egg. Daisy is married to Tom Buchanan, formerly a Yale football star whom Nick knew during his college days. The couple has recently relocated from Chicago to a mansion directly across the bay from Gatsby's estate. There, Nick encounters Jordan Baker, an insolent flapper and golf champion who is a childhood friend of Daisy's. Jordan confides to Nick that Tom keeps a mistress, Myrtle Wilson, who brazenly telephones him at his home and who lives in the \"valley of ashes\", a sprawling refuse dump.[33] That evening, Nick sees Gatsby standing alone on his lawn, staring at a green light across the bay.\n" +
                "\n" +
                "Days later, Nick reluctantly accompanies a drunken and agitated Tom to New York City by train. En route, they stop at a garage inhabited by mechanic George Wilson and his wife Myrtle. Myrtle joins them, and the trio proceed to a small New York apartment that Tom has rented for trysts with her. Guests arrive and a party ensues, which ends with Tom slapping Myrtle and breaking her nose after she mentions Daisy.\n" +
                "\n" +
                "One morning, Nick receives a formal invitation to a party at Gatsby's mansion. Once there, Nick is embarrassed that he recognizes no one and begins drinking heavily until he encounters Jordan. While chatting with her, he is approached by a man who introduces himself as Jay Gatsby and insists that both he and Nick served in the 3rd Infantry Division during the war. Gatsby attempts to ingratiate himself with Nick and when Nick leaves the party, he notices Gatsby watching him.\n" +
                "\n" +
                "Photograph of the Plaza Hotel\n" +
                "The confrontation between Gatsby and Tom occurs in the twenty-story Plaza Hotel, a château-like edifice with an architectural style inspired by the French Renaissance.\n" +
                "In late July, Nick and Gatsby have lunch at a speakeasy. Gatsby tries impressing Nick with tales of his war heroism and his Oxford days. Afterward, Nick meets Jordan at the Plaza Hotel. Jordan reveals that Gatsby and Daisy met around 1917 when Gatsby was an officer in the American Expeditionary Forces. They fell in love, but when Gatsby was deployed overseas, Daisy reluctantly married Tom. Gatsby hopes that his newfound wealth and dazzling parties will make Daisy reconsider. Gatsby uses Nick to stage a reunion with Daisy, and the two embark upon a sexual affair.\n" +
                "\n" +
                "In September, Tom discovers the affair when Daisy carelessly addresses Gatsby with unabashed intimacy in front of him. Later, at a Plaza Hotel suite, Gatsby and Tom argue about the affair. Gatsby insists Daisy declare that she never loved Tom. Daisy claims she loves Tom and Gatsby, upsetting both. Tom reveals Gatsby is a swindler whose money comes from bootlegging alcohol. Upon hearing this, Daisy chooses to stay with Tom. Tom scornfully tells Gatsby to drive her home, knowing that Daisy will never leave him.\n" +
                "\n" +
                "While returning to East Egg, Gatsby and Daisy drive by Wilson's garage and their car accidentally strikes Myrtle, killing her instantly. Gatsby reveals to Nick that Daisy was driving the car, but that he intends to take the blame for the accident to protect her. Nick urges Gatsby to flee to avoid prosecution, but he refuses. After Tom tells George that Gatsby owns the car that struck Myrtle, a distraught George assumes the owner of the vehicle must be Myrtle's lover. George fatally shoots Gatsby in his mansion's swimming pool, then commits suicide.\n" +
                "\n" +
                "Several days after Gatsby's murder, his father Henry Gatz arrives for the sparsely attended funeral. After Gatsby's death, Nick comes to hate New York and decides that Gatsby, Daisy, Tom, and he were all Midwesterners unsuited to Eastern life.[c]\n" +
                "\n" +
                "Nick encounters Tom and initially refuses to shake his hand. Tom admits he was the one who told George that Gatsby owned the vehicle that killed Myrtle. Before returning to the Midwest, Nick returns to Gatsby's mansion and stares across the bay at the green light emanating from the end of Daisy's dock.";

        String ld7 = "Renowned Harvard symbologist Robert Langdon is invited to give a lecture at the United States Capitol, at the invitation apparently from his mentor, a 33rd degree Mason named Peter Solomon, who is the head of the Smithsonian Institution. Solomon has also asked him to bring a small, sealed package which he had entrusted to Langdon years earlier. When Langdon arrives at the Capitol, however, he learns that the invitation he received was not from Solomon, but from Solomon's kidnapper, Mal'akh posing as Solomon's assistant, who has left Solomon's severed right hand in the middle of the Capitol Rotunda in a recreation of the Hand of Mysteries. Mal'akh then contacts Langdon, charging him with finding both the Mason's Pyramid, which Masons believe is hidden somewhere in Washington, D.C., and the Lost Word, lest Solomon be murdered.\n" +
                "\n" +
                "Langdon meets Inoue Sato, the head of the CIA's Office of Security. Sato claims that Mal'akh poses a threat to the national security of the U.S. and that his capture is more important than Peter's rescue, although she refuses to elaborate. Examining Solomon's hand, they discover a clue leading them to Solomon's Masonic altar in a room in the Capitol's sub-basement, where they find a small pyramid lacking a capstone, with an inscription carved into it.\n" +
                "\n" +
                "Sato then confronts Langdon with the security x-ray taken of his bag when he entered the Capitol which reveals a smaller pyramid in the package Langdon brought in response to the request by the kidnapper posing as Solomon's assistant. Langdon explains that he was unaware of its contents, but Sato, refusing to believe it, attempts to take Langdon into custody. Before she can arrest him, however, she and Capitol Police Chief Trent Anderson are assaulted by Warren Bellamy, the Architect of the Capitol and a Freemason, who then flees with Langdon in the confusion. He later explains to Langdon that he too has been in contact with Mal'akh and wants Langdon's assistance in rescuing Peter.\n" +
                "\n" +
                "Mal'akh is revealed to be a Freemason with tattoos covering almost his entire body. He infiltrated the organization in order to obtain an ancient source of power,[9] which he believes Langdon can unlock for him in return for Peter Solomon's life. Several chapters also delve into Mal'akh's history with Peter Solomon: many years earlier, Peter bequeathed a large sum of inheritance money to his rebellious son, Zachary, who then fled the Solomon household and led a reckless life in Europe until he was arrested and imprisoned in Turkey for smuggling drugs. Peter flew to Turkey but decided to have Zachary extradited in a week's time instead of getting him released immediately in order to teach him a lesson. Zachary was apparently murdered by his cellmate who got his hands on Zachary's fortune and fled to the island of Syros in Greece to lead a luxurious life under the name Andros Dareios. Dareios, however, soon grew tired of his life. Apparently having spoken with Zachary about Solomon's life as a Mason, Dareios broke into Solomon's home to find the pyramid, but accidentally killed Peter's mother Isabel and was in turn shot and left to fall into a frozen river by a vengeful Solomon. Surviving the fall, Dareios nursed himself back to health, covered his scars and eventually his entire body with tattoos and set off on a mission to infiltrate the Freemasons and gain access to their secrets, adopting the name Mal'akh.\n" +
                "\n" +
                "As Langdon deals with the events into which he has been thrust, Mal'akh destroys the Smithonsonian-sponsored laboratory of Dr. Katherine Solomon, Peter's younger sister, where she has conducted experiments in Noetic Science, in the process ambushing and almost killing Katherine in a cat-and-mouse chase, but Katherine manages to escape and meet up with Langdon and Bellamy. Eventually, when cornered by the authorities, Bellamy is forced to give himself up while Langdon and Katherine escape. Both are later apprehended by Sato's team. Following clues regarding Mal'akh's previous identity as Peter Solomon's psychiatrist, Dr. Christopher Abaddon, Sato allows Langdon and Katherine to rush to his mansion to confront him, but Mal'akh ambushes them and murders their CIA escort. Meanwhile, as he is being interrogated by Sato, Bellamy expresses belief that Sato is working with Mal'akh but Sato assures Bellamy that she is also pursuing Mal'akh in the interest of national security and displays evidence that visibly shocks Bellamy.\n" +
                "\n" +
                "Mal'akh places Langdon into an airtight sensory deprivation tank, where he interrogates Langdon by slowly filling the tank with liquid. He is able to convince Langdon to decipher the code at the pyramid's base, but continues to fill the tank until Langdon drowns and apparently dies. Mal'akh then ties Katherine to a chair and inserts an open-ended transfusion needle into her arm and leaves her to bleed to death then flees with a weakened and wheelchair-bound Peter Solomon to the Temple Room of the Scottish Rite's House of the Temple. He uses the threat of not calling an ambulance for Katherine as further coercion for Peter's cooperation. Sato leads a team of agents to the mansion after Langdon and Katherine's escort fails to check in and are able to save Katherine's life. After a near-death experience, Langdon is revealed to have survived due to the \"water\" in the tank actually being breathable oxygenated liquid and the tank being a device for meditation. Sato and Langdon race to the House of the Temple where Mal'akh threatens to release a heavily edited video showing government officials performing secret Masonic rituals (the same video that Sato showed to Bellamy), which without context, appears highly disturbing. Mal'akh forces the Word—the unpronounceable circumpunct—out of Peter and tattoos it on his head on the last portion of unmarked skin on his body. Mal'akh then orders Peter to sacrifice him, as he believes that it is his destiny to become a demonic spirit and lead the forces of evil. When Peter claims that he will do so without hesitation to avenge his son and mother, Mal'akh shocks Peter by revealing that he is actually Zachary Solomon himself, having conspired with the prison warden to fake his death by disfiguring the body of another inmate beyond recognition (at the same time, Katherine and Bellamy discover several photos of Zachary in Greece after his supposed death that show his gradual transformation into Mal'akh). With tears in his eyes, Peter prepares to stab Zachary but ultimately cannot bring himself to do so and drops the knife just as Langdon arrives and tackles him. Director Sato arrives at the Temple in a helicopter, which smashes the Temple's skylight, the shards of which fatally impale Zachary. The CIA then thwart Zachary's plan to transmit the video to several leading media channels using an EMP blast, disabling a cell tower in the network path leading from Zachary's laptop computer. Katherine arrives and she and Langdon then share a tearful reunion with Peter and mourn Zachary's death. Zachary is only briefly able to lament his body's mutilation before dying.\n" +
                "\n" +
                "Later, Peter informs Langdon that the circumpunct Zachary tattooed on his head is not the Word. He also informs Katherine that he made back-ups of all of her noetic research data on his own computer, meaning her research can continue. Deciding to take Langdon to the true secret behind the Word, Peter leads him to the room atop the Washington Monument and tells him that the Word—a common Christian Bible, the Word of God—lies in the monument's cornerstone, buried in the ground beneath the monument's staircase. Langdon realizes that the words inscribed in the base of aluminum capstone (Masonic pyramid) atop the Monument spelled out Laus Deo which translate to Praise God.\n" +
                "\n" +
                "Peter tells Langdon that the Masons believe that the Bible is an esoteric allegory written by humanity, and that, like most religious texts around the globe, it contains veiled instructions for harnessing humanity's natural God-like qualities—similar to Katherine's noetic research—and is not meant to be interpreted as the commands of an all-powerful deity. This interpretation has been lost amid centuries of scientific skepticism and fundamentalist zealotry. The Masons have (metaphorically) buried it, believing that, when the time is right, its rediscovery will usher in a new era of human enlightenment.";

        books.add(new Book(1,"Da Vinci Code","Dan Brown",592,
                "https://images-na.ssl-images-amazon.com/images/I/41yT41SG23L._SX294_BO1,204,203,200_.jpg",
                "A murder inside the Louvre, and clues in Da Vinci paintings, lead to the discovery of a religious mystery protected by a secret society for two thousand years, which could shake the foundations of Christianity.",ld1));
        books.add(new Book(2,"The Myth of Sisyphus","Albert Camus",250,
                "https://images-na.ssl-images-amazon.com/images/I/41scfbVq70L._SX322_BO1,204,203,200_.jpg",
                "Individual's persistent struggle against the essential absurdity of life.",ld2));
        books.add(new Book(3,"The Power of Your Subconscious Mind ","Joseph Murphy",256,
                "https://images-na.ssl-images-amazon.com/images/I/51QTTApN-XL._SX324_BO1,204,203,200_.jpg",
                "An ideal book to unravel your sub-consciousness",ld3));
        books.add(new Book(4,"Harry Potter and the Philosopher's Stone","J. K. Rowling",223,
                "https://upload.wikimedia.org/wikipedia/en/6/6b/Harry_Potter_and_the_Philosopher%27s_Stone_Book_Cover.jpg",
                "Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday.",ld4));
        books.add(new Book(5,"The Invisible Life of Addie LaRue","V. E. Schwab",448,
                "https://images-na.ssl-images-amazon.com/images/I/51FVPBt51ZL._SX329_BO1,204,203,200_.jpg",
                "A young French woman in 1714 who makes a bargain with the devil that makes her immortal, but curses her to be forgotten by everyone she meets",ld5));
        books.add(new Book(6,"The Great Gatsby","F. Scott Fitzgerald",208,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/The_Great_Gatsby_Cover_1925_Retouched.jpg/330px-The_Great_Gatsby_Cover_1925_Retouched.jpg",
                "A literary masterwork and a contender for the title of the Great American Novel",ld6));
        books.add(new Book(7,"The Lost Symbol","Dan Brown",528,
                "https://images-eu.ssl-images-amazon.com/images/I/51Zutc5AWcL._SY264_BO1,204,203,200_QL40_FMwebp_.jpg",
                "A mysterious invitation brings Robert Langdon to Washington DC. There, he is presented with a sequence of bloody clues which he must unravel if he is to prevent a terrible plan.",ld7));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOKS_KEY,gson.toJson(books));
        editor.commit();
    }

    public static Utils getInstance(Context context) {
        if (null == instance) {
            instance = new Utils(context);
        }
        return instance;
    }

    public ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS, null), type);
        return books;
    }

    public ArrayList<Book> getWantToReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS, null), type);
        return books;
    }

    public ArrayList<Book> getCurrentlyReadingBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS, null), type);
        return books;    }

    public ArrayList<Book> getFavoriteBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVORITE_BOOKS, null), type);
        return books;
    }

    public Book getBookId(int id){
        ArrayList<Book> books = getAllBooks();
        if(null != books){
    for(Book b: books){
        if(b.getId() == id){
            return b;
        }
    }
        }
    return null;
    }

    public boolean addToAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS);
                editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return  true;
            }
        }
        return false;
    }

    public boolean addToWantToRead(Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS);
                editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return  true;
            }
        }
        return false;
    }

    public boolean addToCurrentlyReading(Book book){
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS);
                editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                editor.commit();
                return  true;
            }
        }
        return false;
    }

    public boolean addToFavorite(Book book){
        ArrayList<Book> books = getFavoriteBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVORITE_BOOKS);
                editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                editor.commit();
                return  true;
            }
        }
        return false;
    }

    public boolean removeFromAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if(null != books){
            for (Book b: books){
                if(b.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ_BOOKS);
                        editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return  true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromWantToRead(Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if(null != books){
            for (Book b: books){
                if(b.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS);
                        editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return  true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromCurrentlyReading(Book book){
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if(null != books){
            for (Book b: books){
                if(b.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS);
                        editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                        editor.commit();
                        return  true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromFavorite(Book book){
        ArrayList<Book> books = getFavoriteBooks();
        if(null != books){
            for (Book b: books){
                if(b.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE_BOOKS);
                        editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                        editor.commit();
                        return  true;
                    }
                }
            }
        }
        return false;
    }

}
