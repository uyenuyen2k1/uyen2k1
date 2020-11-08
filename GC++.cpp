#include <SFML/Graphics.hpp>
using namespace sf;
int field[20][10] = { 0 };
struct Point
{
    int x, y;
} a[4], b[4];
/*
0 1
2 3
4 5 
6 7
*/
int figures[7][4] =
{
    1,3,5,7, // I
    2,4,5,7, // Z
    3,5,4,6, // S
    3,5,4,7, // T
    2,3,5,7, // L
    3,5,7,6, // J
    2,3,4,5, // O
};
bool check()
{
    for (int i = 0; i < 4; i++)
        if (a[i].x < 0 || a[i].x >= 10 || a[i].y >= 20) return 0;
        else if (field[a[i].y][a[i].x]) return 0;

    return 1;
};
int main()
{
    srand(time(0));
    RenderWindow window(VideoMode(320, 480), "Tetris!");
    Texture texture1, texture2, texture3;
    texture1.loadFromFile("../tiles.png");
    //texture2.loadFromFile("../background.png");
    texture3.loadFromFile("../frame.png");
    Sprite s(texture1), background(texture2), frame(texture3);
    int dx = 0; bool rotate = 0; int colorNum = 1;
    float timer = 0, delay = 0.3;
    Clock clock;
    while (window.isOpen())
    {
        float time = clock.getElapsedTime().asSeconds();
        clock.restart();
        timer += time;
        Event e;
        while (window.pollEvent(e))
        {
            if (e.type == Event::Closed)
                window.close();

            if (e.type == Event::KeyPressed)
                if (e.key.code == Keyboard::Up) rotate = 1;
                else if (e.key.code == Keyboard::Left) dx = -1;
                else if (e.key.code == Keyboard::Right) dx = 1;
        }
        if (Keyboard::isKeyPressed(Keyboard::Down)) delay = 0.05;
        //Move
        for (int i = 0; i < 4; i++) { 
            b[i] = a[i]; 
            a[i].x += dx; 
        }
        if (!check()) for (int i = 0; i < 4; i++) a[i] = b[i];
        //Rotate
        if (rotate)
        {
            Point p = a[1]; //the centre of rotation
            for (int i = 0; i < 4; i++)
            {
                int x = a[i].y - p.y;
                int y = a[i].x - p.x;
                a[i].x = p.x - x;
                a[i].y = p.y + y;
            }
            if (!check()) for (int i = 0; i < 4; i++) a[i] = b[i];
        }
        //tick
        if (timer > delay)
        {
            for (int i = 0; i < 4; i++) { 
                b[i] = a[i]; 
                a[i].y += 1; 
            }
            if (!check())
            {
                for (int i = 0; i < 4; i++) field[b[i].y][b[i].x] = colorNum;
                colorNum = 1 + rand() % 7;
                int n = rand() % 7;
                for (int i = 0; i < 4; i++)
                {
                    a[i].x = figures[n][i] % 2;
                    a[i].y = figures[n][i] / 2;
                }
            }
            timer = 0;
        }
        //check line
        int k = 19;
        for (int i = 19; i > 0; i--)
        {
            int count = 0;
            for (int j = 0; j < 10; j++)
            {
                if (field[i][j]) count++;
                field[k][j] = field[i][j];
            }
            if (count <= 10) k--;
        }
        dx = 0; rotate = 0; delay = 0.3;
        //draw
        window.clear();
        window.draw(background);
        for (int i = 0; i < 19; i++)
            for (int j = 0; j < 10; j++)
            {
                if (field[i][j] == 0) continue;
                s.setTextureRect(IntRect(field[i][j] * 18, 0, 18, 18));
                s.setPosition(j * 18, i * 18);
                s.move(28, 31);
                window.draw(s);
            }
        for (int i = 0; i < 4; i++)
        {
            s.setTextureRect(IntRect(colorNum * 18, 0, 18, 18));
            s.setPosition(a[i].x * 18, a[i].y * 18);
            s.move(28, 31);
            window.draw(s);
        }
        window.draw(frame);
        window.display();
    }
}
