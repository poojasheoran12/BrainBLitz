package com.example.brainblitz.data



    val questionList = listOf(
        // EASY
        Question("What is the capital of India?", listOf("Mumbai", "Delhi", "Chennai", "Kolkata"), "Delhi", "Easy"),
        Question("Which planet is known as the Red Planet?", listOf("Earth", "Mars", "Jupiter", "Venus"), "Mars", "Easy"),
        Question("How many sides does a triangle have?", listOf("2", "3", "4", "5"), "3", "Easy"),
        Question("What is H2O commonly known as?", listOf("Oxygen", "Water", "Hydrogen", "Salt"), "Water", "Easy"),
        Question("Which animal is known as the 'King of the Jungle'?", listOf("Tiger", "Lion", "Elephant", "Leopard"), "Lion", "Easy"),
        Question("What is the opposite of 'hot'?", listOf("Cold", "Fire", "Boil", "Warm"), "Cold", "Easy"),
        Question("Which part of the body helps you to see?", listOf("Ears", "Eyes", "Hands", "Nose"), "Eyes", "Easy"),
        Question("What color is formed by mixing red and blue?", listOf("Green", "Purple", "Orange", "Brown"), "Purple", "Easy"),
        Question("How many days are there in a week?", listOf("5", "6", "7", "8"), "7", "Easy"),
        Question("What is 12 + 15?", listOf("27", "25", "22", "30"), "27", "Easy"),
        Question("How many continents are there?", listOf("5", "6", "7", "8"), "7", "Easy"),
        Question("Which language is primarily spoken in Spain?", listOf("French", "Spanish", "German", "Italian"), "Spanish", "Easy"),
        Question("Which gas do plants absorb from the air?", listOf("Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"), "Carbon Dioxide", "Easy"),
        Question("What shape has 4 equal sides?", listOf("Rectangle", "Triangle", "Circle", "Square"), "Square", "Easy"),
        Question("How many legs does a spider have?", listOf("6", "8", "10", "4"), "8", "Easy"),
        Question("What is the boiling point of water in Celsius?", listOf("90°C", "100°C", "120°C", "80°C"), "100°C", "Easy"),
        Question("Who painted the Mona Lisa?", listOf("Picasso", "Leonardo da Vinci", "Van Gogh", "Rembrandt"), "Leonardo da Vinci", "Easy"),
        Question("Which ocean is the largest?", listOf("Atlantic", "Indian", "Arctic", "Pacific"), "Pacific", "Easy"),
        Question("Which fruit has its seeds on the outside?", listOf("Apple", "Strawberry", "Mango", "Banana"), "Strawberry", "Easy"),
        Question("How many hours are there in a day?", listOf("12", "24", "36", "48"), "24", "Easy"),
        Question("Who developed the theory of relativity?", listOf("Newton", "Einstein", "Tesla", "Edison"), "Einstein", "Medium"),
        Question("Which is the smallest prime number?", listOf("0", "1", "2", "3"), "2", "Medium"),
        Question("What is the capital of Canada?", listOf("Toronto", "Vancouver", "Ottawa", "Montreal"), "Ottawa", "Medium"),
        Question("Which part of the plant conducts photosynthesis?", listOf("Root", "Stem", "Leaf", "Flower"), "Leaf", "Medium"),
        Question("How many bones are there in the adult human body?", listOf("206", "201", "210", "200"), "206", "Medium"),
        Question("Which gas is most abundant in Earth's atmosphere?", listOf("Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"), "Nitrogen", "Medium"),
        Question("Which is the largest internal organ in the human body?", listOf("Heart", "Liver", "Lungs", "Kidney"), "Liver", "Medium"),
        Question("Who wrote 'Romeo and Juliet'?", listOf("Charles Dickens", "William Shakespeare", "Jane Austen", "Leo Tolstoy"), "William Shakespeare", "Medium"),
        Question("Which planet has the most moons?", listOf("Mars", "Jupiter", "Saturn", "Neptune"), "Saturn", "Medium"),
        Question("What is the square root of 144?", listOf("10", "11", "12", "13"), "12", "Medium"),
        Question("Which Indian state has the longest coastline?", listOf("Tamil Nadu", "Andhra Pradesh", "Gujarat", "Maharashtra"), "Gujarat", "Medium"),
        Question("In which year did World War II end?", listOf("1942", "1945", "1948", "1950"), "1945", "Medium"),
        Question("Which scientist proposed the laws of motion?", listOf("Newton", "Einstein", "Kepler", "Galileo"), "Newton", "Medium"),
        Question("Which is the only even prime number?", listOf("2", "4", "6", "8"), "2", "Medium"),
        Question("Who is known as the father of computers?", listOf("Alan Turing", "Charles Babbage", "Tim Berners-Lee", "Ada Lovelace"), "Charles Babbage", "Medium"),
        Question("Which Indian city is called the Silicon Valley of India?", listOf("Mumbai", "Hyderabad", "Chennai", "Bangalore"), "Bangalore", "Medium"),
        Question("Which is the longest river in the world?", listOf("Amazon", "Nile", "Yangtze", "Ganga"), "Nile", "Medium"),
        Question("How many players are there in a cricket team?", listOf("10", "11", "12", "13"), "11", "Medium"),
        Question("Who invented the light bulb?", listOf("Graham Bell", "Einstein", "Thomas Edison", "Newton"), "Thomas Edison", "Medium"),
        Question("Which vitamin is obtained from sunlight?", listOf("Vitamin A", "Vitamin B", "Vitamin C", "Vitamin D"), "Vitamin D", "Medium"),
        Question("What is the hardest natural substance on Earth?", listOf("Gold", "Iron", "Diamond", "Quartz"), "Diamond", "Hard"),
        Question("Which Nobel Prize did Malala Yousafzai win?", listOf("Peace", "Literature", "Physics", "Economics"), "Peace", "Hard"),
        Question("What is the SI unit of electric current?", listOf("Volt", "Ohm", "Watt", "Ampere"), "Ampere", "Hard"),
        Question("Which element has the atomic number 1?", listOf("Oxygen", "Hydrogen", "Carbon", "Helium"), "Hydrogen", "Hard"),
        Question("What is the currency of Japan?", listOf("Dollar", "Yen", "Won", "Peso"), "Yen", "Hard"),
        Question("Who wrote 'The Republic'?", listOf("Aristotle", "Socrates", "Plato", "Homer"), "Plato", "Hard"),
        Question("Which country has won the most FIFA World Cups?", listOf("Germany", "Brazil", "Argentina", "France"), "Brazil", "Hard"),
        Question("Which scientist is famous for the uncertainty principle?", listOf("Bohr", "Einstein", "Heisenberg", "Planck"), "Heisenberg", "Hard"),
        Question("What is the value of Pi to 3 decimal places?", listOf("3.142", "3.141", "3.143", "3.140"), "3.142", "Hard"),
        Question("In which layer of the atmosphere does weather occur?", listOf("Stratosphere", "Mesosphere", "Thermosphere", "Troposphere"), "Troposphere", "Hard"),
        Question("What was the first artificial satellite?", listOf("Apollo", "Sputnik 1", "Voyager", "Chandrayaan"), "Sputnik 1", "Hard"),
        Question("Who discovered Penicillin?", listOf("Newton", "Alexander Fleming", "Curie", "Pasteur"), "Alexander Fleming", "Hard"),
        Question("Which Indian mathematician is known for infinite series?", listOf("Ramanujan", "Aryabhata", "Bhaskaracharya", "Raman"), "Ramanujan", "Hard"),
        Question("What does DNA stand for?", listOf("Dynamic Nucleic Acid", "Deoxyribonucleic Acid", "Dioxynitric Acid", "Dextroribonucleic Acid"), "Deoxyribonucleic Acid", "Hard"),
        Question("What is the capital of Norway?", listOf("Oslo", "Copenhagen", "Stockholm", "Helsinki"), "Oslo", "Hard"),
        Question("Which metal is liquid at room temperature?", listOf("Mercury", "Aluminum", "Iron", "Silver"), "Mercury", "Hard"),
        Question("What does HTTP stand for?", listOf("Hypertext Transfer Protocol", "High Transfer Text Protocol", "Host Transfer Technical Protocol", "Hyper Technical Transfer Protocol"), "Hypertext Transfer Protocol", "Hard"),
        Question("Which blood group is a universal donor?", listOf("O+", "O-", "AB+", "A-"), "O-", "Hard"),
        Question("Who painted 'Starry Night'?", listOf("Van Gogh", "Monet", "Da Vinci", "Picasso"), "Van Gogh", "Hard"),
        Question("Which country launched the first satellite to Mars?", listOf("USA", "Russia", "India", "China"), "India", "Hard"),


        Question(
            question = "What is the capital of India?",
            options = listOf("Mumbai", "Delhi", "Bangalore", "Chennai"),
            answer = "Delhi",
            difficulty = "Easy"
        ),
        Question(
            question = "Which color is made by mixing red and white?",
            options = listOf("Pink", "Orange", "Purple", "Brown"),
            answer = "Pink",
            difficulty = "Easy"
        ),
        Question(
            question = "How many days are there in a leap year?",
            options = listOf("364", "365", "366", "367"),
            answer = "366",
            difficulty = "Easy"
        ),
        Question(
            question = "What shape is a stop sign?",
            options = listOf("Circle", "Hexagon", "Octagon", "Triangle"),
            answer = "Octagon",
            difficulty = "Easy"
        ),
        Question(
            question = "Which planet is closest to the sun?",
            options = listOf("Mercury", "Venus", "Mars", "Earth"),
            answer = "Mercury",
            difficulty = "Easy"
        ),

        // MEDIUM
        Question(
            question = "Who painted the Mona Lisa?",
            options = listOf("Vincent Van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Claude Monet"),
            answer = "Leonardo da Vinci",
            difficulty = "Medium"
        ),
        Question(
            question = "Which gas is most abundant in Earth’s atmosphere?",
            options = listOf("Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"),
            answer = "Nitrogen",
            difficulty = "Medium"
        ),
        Question(
            question = "What is the capital of Australia?",
            options = listOf("Sydney", "Canberra", "Melbourne", "Brisbane"),
            answer = "Canberra",
            difficulty = "Medium"
        ),
        Question(
            question = "What does HTTP stand for?",
            options = listOf("HyperText Transfer Protocol", "High Transfer Text Protocol", "Hyper Transfer Text Packet", "Hybrid Transfer Text Protocol"),
            answer = "HyperText Transfer Protocol",
            difficulty = "Medium"
        ),
        Question(
            question = "In which year did World War II end?",
            options = listOf("1940", "1942", "1945", "1947"),
            answer = "1945",
            difficulty = "Medium"
        ),

        // HARD
        Question(
            question = "Who developed the theory of general relativity?",
            options = listOf("Isaac Newton", "Albert Einstein", "Nikola Tesla", "Stephen Hawking"),
            answer = "Albert Einstein",
            difficulty = "Hard"
        ),
        Question(
            question = "Which is the only bird that can fly backward?",
            options = listOf("Eagle", "Hummingbird", "Owl", "Falcon"),
            answer = "Hummingbird",
            difficulty = "Hard"
        ),
        Question(
            question = "Which element has the atomic number 79?",
            options = listOf("Platinum", "Gold", "Silver", "Copper"),
            answer = "Gold",
            difficulty = "Hard"
        ),
        Question(
            question = "In computer science, what does 'FIFO' stand for?",
            options = listOf("First In First Out", "Fast In Fast Out", "File In File Out", "Function In Function Out"),
            answer = "First In First Out",
            difficulty = "Hard"
        ),
        Question(
            question = "What is the derivative of sin(x)?",
            options = listOf("cos(x)", "-cos(x)", "sin(x)", "-sin(x)"),
            answer = "cos(x)",
            difficulty = "Hard"
        )
    )

