$(document).ready(function() {
  var next = 1;
  $(".add-more").click(function(e) {
    e.preventDefault();
    var addto = "#field" + next;
    next = next + 1;
    if (next < 9) {
      var newIn = '<br /><br /><input autocomplete="off" class="span3" id="field' + next + '" name="field' + next + '" type="text" data-provide="typeahead" data-items="8">';
      var newInput = $(newIn);
      $(addto).after(newInput);
      $("#field" + next).attr('data-source', $(addto).attr('data-source'));
      $("#count").val(next);
    } else if (next == 9) {
      /*to show the message only once*/
      var newIn = '<br /><br /> <div class="span3 alert alert-warning" id="field' + next + '" name="field' + next + '"role="alert" data-provide="typeahead" data-items="8"> You can\'t add anymore fields</div>';
      var newInput = $(newIn);
      $(addto).after(newInput);
      $("#field" + next).attr('data-source', $(addto).attr('data-source'));
      $("#count").val(next);
      $("#b1").remove();
    }
  });
});
