package br.com.brfilmes.config;

import br.com.brfilmes.model.Movie;
import br.com.brfilmes.model.User;
import br.com.brfilmes.repository.MovieRepository;
import br.com.brfilmes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Filmes

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public DataInitializer(UserRepository userRepository, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Para Criar o usuario administrador
        if (userRepository.count() == 0) {
            User user = new User();
            user.setName("Admin");
            user.setEmail("teste@example.com");
            user.setPassword("123456");
            userRepository.save(user);
        }

        // Limpar todos os filmes existentes do banco de dados
        movieRepository.deleteAll();
        System.out.println("Todos os filmes foram removidos com sucesso!");
    
        // Criar novos filmes! só usar o script a baixo e ser feliz.
        createMovie("O Auto da Compadecida", 
                "As aventuras de João Grilo e Chicó, dois nordestinos pobres que vivem de golpes para sobreviver. Eles estão sempre enganando o povo de um pequeno vilarejo, inclusive o temido cangaceiro Severino de Aracaju, que os persegue pela região.",
                "Guel Arraes", 2000, "Comédia", 
                "https://static.wixstatic.com/media/5f4c7f_8324b5c7b07d46e5a3deeac4759f3216~mv2.jpg/v1/fill/w_568,h_320,al_c,q_80,usm_0.66_1.00_0.01,enc_avif,quality_auto/5f4c7f_8324b5c7b07d46e5a3deeac4759f3216~mv2.jpg",
                "https://www.youtube.com/embed/Qs7hLAWyOgA?si=sGFQSs3PpO3-ggT1\" title=");

            createMovie("Cidade dos Homens",
                    "Acerola e Laranjinha são dois amigos que foram criados juntos na favela. Ao completar 18 anos, precisam lidar com as responsabilidades da vida adulta e os riscos do crime organizado.",
                    "Paulo Morelli",
                    2007,
                    "Drama",
                    "https://images.justwatch.com/poster/309931571/s718/cidade-dos-homens.jpg",
                    "https://www.youtube.com/embed/QgvFqGxKT8s?si=amlVis2pPGtQz8fu\" title=");
            
            createMovie("Tropa de Elite 2",
                    "Depois de uma operação fracassada, Nascimento é afastado do Bope e agora trabalha como subsecretário de Inteligência na Secretaria de Segurança Pública do Rio de Janeiro. No novo cargo, o ex-capitão é arrastado para uma disputa política sangrenta que envolve funcionários do governo e grupos paramilitares.",
                    "José Padilha", 2010, "Ação",
                    "https://m.media-amazon.com/images/S/pv-target-images/ab682dc12a55d4ab63614d77088918b2e5b6f2c5b898652e57fc50aa65f12f62.jpg",
                    "https://www.youtube.com/embed/Agf8uIV8eXU?si=t5KWEnFq1GGAe9QQ\" title=");

            createMovie("Cidade de Deus",
                    "Buscapé é um jovem pobre, negro e sensível, que cresce em um universo de muita violência. Ele vive na Cidade de Deus, favela carioca conhecida por ser um dos locais mais violentos do Rio. Amedrontado com a possibilidade de se tornar um bandido, Buscapé é salvo de seu destino por causa de seu talento como fotógrafo.",
                    "Fernando Meirelles", 2002, "Drama",
                    "https://br.web.img3.acsta.net/img/22/92/2292efd71e78438c8686d9d7f57a61a7.jpg",
                    "https://www.youtube.com/embed/2zxkx05zFU8?si=A2ghCh_NCgBP0PLt\" title=");

            createMovie("Meu Nome Não É Johnny",
                    "João Guilherme Estrella é um jovem da classe média que se torna o rei do tráfico de drogas da zona sul do Rio de Janeiro. Carismático e adorado por todos, ele mantém seu envolvimento com drogas em segredo mesmo das pessoas mais próximas.",
                    "Mauro Lima", 2008, "Drama",
                    "https://upload.wikimedia.org/wikipedia/pt/f/f1/Meu_Nome_n%C3%A3o_%C3%89_Johnny.jpg",
                    "https://www.youtube.com/embed/1T-1pwcyN5c?si=LA04uoT7oZCAnXjq\" title=");

            createMovie("Taxi 4",
                    "Um bandido belga procurado em toda a Europa consegue enganar os policiais de Marselha antes de ser transferido para uma prisão na África. As coisas se complicam ainda mais quando a esposa de um dos agentes se infiltra na gangue do criminoso.",
                    "Gérard Krawczyk", 2007, "Ação",
                    "https://beam-images.warnermediacdn.com/BEAM_LWM_DELIVERABLES/f8453d74-5a3e-4a17-9ba2-153c482bd949/4a28d116-e693-4c2a-bd89-c739415021ec?host=wbd-images.prod-vod.h264.io&partner=beamcom",
                    "https://www.youtube.com/embed/n6VCD2cTMcI?si=3csIr2aT40XQGNFK\" title=");

            createMovie("Que Horas Ela Volta?",
                    "Val é uma empregada doméstica que trabalha para uma família rica em São Paulo. Quando sua filha, que não vê há anos, vem para a cidade para prestar vestibular, as tensões surgem e as relações de classe são questionadas.",
                    "Anna Muylaert", 2015, "Drama",
                    "https://m.media-amazon.com/images/S/pv-target-images/074577ce3287d90567f2f3982f0f142b8c8745fe2e35f8f17eae9ffd7066de5e.jpg",
                    "https://www.youtube.com/embed/pD-8ZeEFC_Y?si=EOyN48yoPy2dKVPZ\" title=");

            createMovie("Os Parças 2",
                    "Romeu precisa conseguir dinheiro e deixar o país o quanto antes para escapar de China, que saiu da cadeia e busca vingança. Para ajudá-lo, Toinho, Ray Van e Pilôra juntam forças para reformar uma colônia de férias. Quando o empreendimento começa a funcionar, eles logo passam a competir com uma colônia vizinha, bem mais requintada.",
                    "Cris D'Amato", 2019, "Comédia",
                    "https://m.media-amazon.com/images/S/pv-target-images/a649d8a0ebd260e6ec05990850f5611ae3b21514902962acfcac9fb625e7af67.jpg",
                    "https://www.youtube.com/embed/WwDa-KPW7do?si=lfGqG0ZPFMww_O5Q\" title=");

            createMovie("Morando com o Crush",
                    "Luana tem 15 anos e está apaixonada por seu colega de classe, Hugo. A menina vive com seu pai, um viúvo que, como ela, não tem sorte no amor. Mas isso muda quando ele resolve apresentar sua nova namorada, que por coincidência é a mãe de Hugo. Os pais decidem ir morar juntos em uma pequena cidade e os dois são obrigados a dividir o mesmo teto. Mesmo se sentindo sufocada por essa mudança, a garota vê seu amor por Hugo crescer a cada dia.",
                    "Hsu Chien", 2024, "Romance",
                    "https://i.ytimg.com/vi/73IFN40QFzo/maxresdefault.jpg",
                    "https://www.youtube.com/embed/Ch4Qrdhpxmc?si=Pc2N5z7BaVknLHdj\" title=");

            createMovie("Curupira - O Demônio Da Floresta",
                    "Beto, Marcos, Diana, Kauã, Carol e Jéssica que decidem se aventurar pela mata em um fim de semana, mas logo percebem que estão sendo perseguidos por uma criatura misteriosa e só um velho caçador pode ajudá-los.",
                    "Erlanes Duarte", 2021, "Terror",
                    "https://br.web.img2.acsta.net/c_310_420/pictures/21/10/14/19/05/1685970.jpg",
                    "https://www.youtube.com/embed/xdZjhqi-5dY?si=GkHRTFmEmhpGFTCp\" title=");

        createMovie("O Despertar da Besta",
                "O psiquiatra Dr. Sérgio teoriza que as perversões sexuais são causadas pelo uso de drogas. Para tentar provar sua tese, ele faz experimentos com LSD em quatro voluntários e apresenta seus resultados a outros psiquiatras em um programa de televisão, sendo veementemente contestado. Para comprovar sua teoria, ele orienta os voluntários a encararem um cartaz do filme \"O Estranho Mundo de Zé do Caixão\" e, a seguir, são mostradas as experiências de cada um dos usuários.",
                "José Mojica Marins", 1970, "Terror",
                "https://m.media-amazon.com/images/S/pv-target-images/6b44b3025aaaa3987605a299d38c858e6c2d3a55016f1936171cfb34317f8762.jpg",
                "https://www.youtube.com/embed/3bILzEXU3eQ?si=7HCFMVOqT49IPVvH\" title=");

        createMovie("Loop",
                "A namorada de Daniel é assassinada, e ele fica obcecado em encontrar um jeito de voltar no tempo. Na expectativa de mudar os fatos, o rapaz acaba preso em um looping de acontecimentos.",
                "Bruno Bini", 2021, "Ficção Científica",
                "https://play-lh.googleusercontent.com/qRYqEbYsjNdckVeyvHKbU_To2DmwQ7TUskrdWRus3fuxQoFKO8BxnfIGRAMRFnNbg_5TZLVg-a8_8g0PJg",
                "https://www.youtube.com/embed/ACP2lmv80H0?si=Yternh-1n0Hw9O0i\" title=");

    }
    
    private void createMovie(String title, String description, String director, Integer releaseYear, 
                           String genre, String imageUrl, String videoUrl) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDescription(description);
        movie.setDirector(director);
        movie.setReleaseYear(releaseYear);
        movie.setGenre(genre);
        movie.setImageUrl(imageUrl);
        movie.setVideoUrl(videoUrl);
        movieRepository.save(movie);
    }
}
