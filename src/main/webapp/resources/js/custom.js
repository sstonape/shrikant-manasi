$(document).on("ready",function(){  
    _initSlider();
    _showCount();
    $(".single_image").fancybox();
    $(".btnc").on("click",function() {
      var eTarget = $(this).data("target")
      if($(".inputName").val().length >= 2){
    	  $(eTarget).slideDown("slow");
    	  setTimeout(function(){
    	     $(eTarget).slideUp("slow");
    	     $("html, body").animate({ scrollTop: 0 }, 600);  
    	     $(".inputName").val('');
    	  }, 2500);  

      }
      
    });
});
/**
 * Use to init slider 
 */
var _initSlider = function(){
  $('.heroSlider').vegas({
      overlay: true,
      transition: 'fade', 
      transitionDuration: 7000,
      delay: 12000,
      color: 'red',
      animation: 'random',
      animationDuration: 20000,
      slides: [
		{ src: 'resources/images/edited/slide1.jpg' },
		{ src: 'resources/images/edited/shrikant-manasi2.jpg' },
		{ src: 'resources/images/shrikant-manasi3.JPG' },
		{ src: 'resources/images/shrikant-manasi6.JPG' },
		{ src: 'resources/images/edited/shrikant-manasi7.jpg' },
		{ src: 'resources/images/edited/shrikant-manasi8.jpg' },
		{ src: 'resources/images/edited/shrikant-manasi9.jpg' },
		{ src: 'resources/images/edited/shrikant-manasi11.jpg' },
      ]
    });
};
/**
 * Use to show countdown timeer
 */
var  _showCount = function(){
    var deadline = '2016/12/03 10:31:00';
    $(".remTime")
      .countdown(deadline, function(event) {
        $(this).find(".week").html(event.strftime('%W'));
        $(this).find(".days").html(event.strftime('%D'));
        $(this).find(".hr").html(event.strftime('%H'));
        $(this).find(".min").html(event.strftime('%M'));
        $(this).find(".sec").html(event.strftime('%S'));       
    });   
}
