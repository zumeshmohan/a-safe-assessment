import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { JokeService } from '../joke.service';
import { Joke } from '../joke.model'

@Component({
  selector: 'app-joke',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  providers: [JokeService],
  templateUrl: './joke.component.html',
  styleUrls: ['./joke.component.css'],
})
export class JokeComponent {
    joke: Joke | null = null;
    showPunchline = false;
    currentId = 1;
    jokeCount = 0;

    constructor(private jokeService : JokeService){}

    ngOnInit(){

      this.jokeService.getJokeCount().subscribe((count) => {
        this.jokeCount = count;
        this.loadJoke(this.currentId);
        });
      }

    loadJoke(id: number){
      this.jokeService.getJoke(id).subscribe({
        next: (joke) => {
            this.joke = joke;
            this.showPunchline = false;
          },
        error:() => {
            this.joke =null;
          }
        });
      }

    revealPunchline() {
        this.showPunchline = true;
      }

    nextJoke() {
        this.currentId = this.currentId % this.jokeCount + 1;
        this.loadJoke(this.currentId);
      }
}
