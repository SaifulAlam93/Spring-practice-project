import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.scss']
})
export class ButtonComponent {

  @Input() text! :string;
  @Input() color! :string;
  @Output() btn = new EventEmitter();

  onClick() {
    this.btn.emit();
  }
}
