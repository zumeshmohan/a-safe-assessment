
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { JokeService } from './joke.service';
import { JokeComponent } from './joke/joke.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, HttpClientModule, JokeComponent],
  providers: [JokeService],
  templateUrl: './app.html',
  styleUrls: ['./app.css'],
})
export class App {
  protected title = 'jokes-ui';
  }
