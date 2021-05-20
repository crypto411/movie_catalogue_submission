package com.user.fadhlanhadaina.moviecataloguesubmission.data.model

object ResourceData {
    val movieFavoriteTest = MovieFavorite(
        460465,
        "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
        "Mortal Kombat",
        "2021-04-07",
        "Action, Fantasy, Adventure, Science Fiction"
    )
    val movieTest = Movie(
            460465,
            "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
            "Mortal Kombat",
            "2021-04-07",
        "",
            arrayListOf(
                Genre(28, "Action"),
                Genre(14, "Fantasy"),
                Genre(12, "Adventure"),
                Genre(878, "Science Fiction")
            ),
            110,
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe."
    )

    val movieListTest = arrayListOf(
        movieTest
    )
//    val movieLists = arrayListOf(
//        Movie(
//            1,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
//            "Godzilla vs. Kong",
//            "03/24/2021",
//                ArrayList(2),
//            "Action, Science Fiction",
//            "1h 53m",
//            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
//        ),
//        Movie(
//            2,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
//            "Zack Snyder's Justice League",
//            "03/18/2021",
//            "Action, Adventure, Fantasy, Science Fiction",
//            "4h 2m",
//            "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
//        ),
//        Movie(
//            3,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8yhtzsbBExY8mUct2GOk4LDDuGH.jpg",
//            "Mortal Kombat",
//            "04/14/2021",
//            "Fantasy, Action, Adventure",
//            "1h 50m",
//            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
//        ),
//        Movie(
//            4,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/279yOM4OQREL36B3SECnRxoB4MZ.jpg",
//            "Thunder Force",
//            "04/09/2021",
//            "Action, Adventure, Comedy, Fantasy",
//            "1h 47m",
//            "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
//        ),
//        Movie(
//            5,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
//            "Chaos Walking",
//            "04/07/2021",
//            "Science Fiction, Action, Adventure, Thriller",
//            "1h 49m",
//            "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
//        ),
//        Movie(
//            6,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
//            "The Marksman",
//            "01/15/2021",
//            "Action, Thriller, Crime",
//            "1h 48m",
//            "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
//        ),
//        Movie(
//            7,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
//            "Raya and the Last Dragon",
//            "03/03/2021",
//            "Animation, Adventure, Fantasy, Family, Action",
//            "1h 47m",
//            "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
//        ),
//        Movie(
//            8,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4VlXER3FImHeFuUjBShFamhIp9M.jpg",
//            "Mortal Kombat Legends: Scorpion's Revenge",
//            "04/12/2020",
//            "Animation, Action, Fantasy",
//            "1h 20m",
//            "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
//        ),
//        Movie(
//            9,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
//            "Monster Hunter",
//            "01/13/2021",
//            "Fantasy, Action, Adventure",
//            "1h 44m",
//            "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
//        ),
//        Movie(
//            10,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fFRq98cW9lTo6di2o4lK1qUAWaN.jpg",
//            "Sentinelle",
//            "03/05/2021",
//            "Thriller, Action, Drama",
//            "1h 20m",
//            "Transferred home after a traumatizing combat mission, a highly trained French soldier uses her lethal skills to hunt down the man who hurt her sister.",
//        ),
//    )
    val tvSeriesFavoriteTest = TVSeriesFavorite(
    88396,
    "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
    "The Falcon and the Winter Soldier",
    "2021-03-19",
    "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics",
)
    val tvSeriesTest = TVSeries(
            88396,
            "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            "The Falcon and the Winter Soldier",
            "2021-03-19",
            "",
            arrayListOf(
                Genre(10765, "Sci-Fi & Fantasy"),
                Genre(10759, "Action & Adventure"),
                Genre(18, "Drama"),
                Genre(10768, "War & Politics")
            ),
            arrayListOf(
                50
            ),
        50,
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience."
    )
    val tvSerieListTest = arrayListOf(
        tvSeriesTest
    )
//    val tvSerieLists = arrayListOf(
//        TVSeries(
//            1,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
//            "The Falcon and the Winter Soldier",
//            "19/03/2021",
//            "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics",
//            [50],
//            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
//        ),
//        TVSeries(
//            2,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
//            "The Good Doctor",
//            "25/09/2017",
//            "Drama",
//            43,
//            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
//        ),
//        TVSeries(
//            3,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
//            "The Flash",
//            "19/04/2016",
//            "Drama, Sci-Fi & Fantasy",
//            44,
//            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
//        ),
//        TVSeries(
//            4,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
//            "Invincible",
//            "26/03/2021",
//            "Animation, Action & Adventure, Drama",
//            45,
//            "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
//        ),
//        TVSeries(
//            5,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
//            "Grey's Anatomy",
//            "08/01/2006",
//            "Drama",
//            43,
//            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
//        ),
//        TVSeries(
//            6,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
//            "Riverdale",
//            "26/01/2017",
//            "Mystery, Drama, Crime",
//            45,
//            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
//        ),
//        TVSeries(
//            7,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
//            "Lucifer",
//            "10/08/2015",
//            "Crime, Sci-Fi & Fantasy",
//            45,
//            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
//        ),
//        TVSeries(
//            8,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
//            "WandaVision",
//            "15/01/2021",
//            "Sci-Fi & Fantasy, Mystery, Drama",
//            36,
//            "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
//        ),
//        TVSeries(
//            9,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
//            "The Walking Dead",
//            "11/10/2010",
//            "Action & Adventure, Drama, Sci-Fi & Fantasy",
//            42,
//            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
//        ),
//        TVSeries(
//            10,
//            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
//            "Who Killed Sara?",
//            "24/03/2021",
//            "Drama, Crime, Mystery",
//            40,
//            "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
//        ),
//    )
}